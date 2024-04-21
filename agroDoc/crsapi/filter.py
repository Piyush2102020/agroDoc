import pandas as pd
data=pd.read_csv('auth_data.csv')


df_list=[]
for i in range(len(data)):
    sample=data.iloc[i]
    n=sample['n']
    p=sample['p']
    k=sample['k']
    r=sample['zone']
    s=sample['soil'].split(',')
    crop=sample['crop']
    for soil in s:
        for z in range(0,250):
            df={"n":n*z,"k":k*z,"p":p*z,"soil":soil,"zone":r,"crop":crop}
            df_list.append(df)
            
            
            
df_dataFrame=pd.DataFrame(df_list,index=None)
print(df_dataFrame)

df_dataFrame.to_csv('crop_data_1.csv',index=False)