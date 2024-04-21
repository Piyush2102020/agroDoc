import firebase_admin
from firebase_admin import credentials
from crs import crs
import torch
import torch.nn as nn
from firebase_admin import db 
import pandas as pd

cred = credentials.Certificate("Download you firebase certiicate and paste the path")
firebase_admin.initialize_app(cred, {
    'databaseURL': 'enter your database url'
})


data = pd.read_csv('crop_data.csv')
soil_types = sorted(set(data['soil'].str.lower()))
region = sorted(set(data['zone'].str.lower()))
crops = sorted(set(data['crop'].str.lower()))
crops = set([crop.strip() for crop in crops])
soiltoi = {s: i for i, s in enumerate(soil_types)}
croptoi = {s: i for i, s in enumerate(crops)}
itocrop = {i: s for s, i in croptoi.items()}
regiontoi = {r: i for i, r in enumerate(region)}


model = crs(in_size=5, hidden=20, out=len(crops))

#Note train the model to get the crs.pth file else use the default one
model.load_state_dict(torch.load('crs.pth'))

model.eval()



ref = db.reference()

def handle_child_added(event):
    data_f = event.data
    print(f"Request received with data {data_f}")
    if data_f is not None:
        
        n=int(data_f['n'])
        p=int(data_f['p'])
        k=int(data_f['k'])
        r=regiontoi[data_f['r']]
        s=soiltoi[data_f['s']]
        logits = model(torch.tensor([r, s, n, p, k], dtype=torch.float32).unsqueeze(dim=0))
        prob = torch.multinomial(logits.exp(), num_samples=len(crops), replacement=False)
        probs = prob.tolist()[0]
        output = [itocrop[crop] for crop in probs]
            # Store predictions under the 'prediction' node using the child key as identifier
        ref.child('out').set(output)







ref.child('prediction').listen(handle_child_added)
print("Server Online...")