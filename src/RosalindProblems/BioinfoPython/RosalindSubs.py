
import os
s=open(os.getcwd()+"\subs.txt","r")
p=open(os.getcwd()+"\esult.txt","w+")
w=0
sub1=""
sub2=""
for v in s.readlines():
	if w==0:
		sub1+=v.rstrip()
	if w==1:
		sub2+=v.rstrip()
		w=0
	w+=1
x=0
y=len(sub2)
result=""
while y<=len(sub1):
	if sub1.find(sub2,x,y)!=-1:
		result+=str(sub1.find(sub2,x,y)+1)+" "
	x+=1
	y+=1
print result
p.write(result)
p.close()
s.close()