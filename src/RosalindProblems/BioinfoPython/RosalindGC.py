import os
s=open(os.getcwd()+"\chivo.txt","r")
ids=""
ADN=""
result=0
finalid=""
res=0
def cont(ADN):
	conts=0
	for x in ADN:
		if x=='G'or x=='C':
			conts+=1
	return conts/len(ADN)*100

while True:
	
	cadena=s.read(1)
	if not cadena:break	
	if cadena=='>' or cadena=='!':
		flag=0
		if ADN!="":
			print ADN
			res=cont(ADN)
			print res
			if res>result:
				result=res
				finalid=ids
				ADN=""
				ids=""
		ADN=""
		ids=""
	elif flag==0:
		ids+=cadena
		if cadena=='\n':
			flag=1
	elif flag==1:
		if cadena!='\n':
			ADN+=cadena
s.close()



