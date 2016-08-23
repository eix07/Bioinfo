import os
s=open(os.getcwd()+"\hamm.txt","r")
p=open(os.getcwd()+"esult.txt","w+")

cadena1=""
cadena2=""
w=0
result=0
for v in s.readlines():
	if w==0:
		cadena1=v.rstrip()
	if w==1:
		cadena2=v.rstrip()
	w+=1
list1=list(cadena1)
list2=list(cadena2)

for j,k in zip(list1,list2):
	if j!=k:
		result+=1
print result