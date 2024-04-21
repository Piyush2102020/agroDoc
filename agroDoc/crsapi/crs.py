import torch
import torch.nn as nn
class crs(nn.Module):
  def __init__(self,in_size,out,hidden):
    super().__init__()
    self.block=nn.Sequential(
        nn.Linear(in_features=in_size,out_features=hidden),
        nn.Tanh(),
        nn.Linear(in_features=hidden,out_features=hidden),
        nn.Linear(in_features=hidden,out_features=hidden),
        nn.Linear(in_features=hidden,out_features=hidden),
        nn.Linear(in_features=hidden,out_features=hidden),
        nn.Linear(in_features=hidden,out_features=hidden),
        nn.ReLU(),
       
        nn.Linear(in_features=hidden,out_features=out)
    )

  def forward(self,x):
    return self.block(x)


