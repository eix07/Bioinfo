import os.path as path
from functools import wraps
import time
import types
import os

def timethis(func):
	@wraps(func)
	def wrapper(*args,**kwargs):
		start=time.time()
		result=func(*args,**kwargs)
		end=time.time()
		print(func.__name__,end-start)
		return result
	return wrapper

def inverr(obj):
		def decorate(func):
			@wraps(func)
			def wrapper(*args,**kwargs):
				print func(*args,**kwargs)
				file=open(str(obj),"r")
				out=open(str(os.getcwd()+"\inverso.fasta"),"w+")
				while True:
					cadena=file.read(1)
					if not cadena:break
					if cadena=='\n':
						out.write("\n")
					else:
						out.write(str(inv(cadena)))	
				file.close()
				out.close()
						
			return wrapper
		return decorate
def inv(c):
	if(c=='T'or c=='U'or c=='t'or c=='u'):
		return 'A'
	if(c=='A'or c=='a'):
		return 'C'
	if(c=='C'or c=='c'):
		return 'G'
	if(c=='G'or c=='g'):
		return 'C'

class FastaRead:
	def __init__(self,direcci):
		self.direccion=direcci
	@timethis
	def read(self):
		file=open(self.direccion,"r")
		out=open(str(os.getcwd()+"\cadenaFasta.temp"),"w+")
		flag=0
		while True:
			cadena=file.read(1)
			if not cadena:break	
			if cadena=='>':
				flag=0
				out.write("\n")
				print cadena
			elif flag==0:
				print cadena
				if cadena=='\n':
					flag=1
			elif flag==1:
				out.write(cadena)
		file.close()
		out.close()
	def prin(self):
		file=open(self.direccion,"r")
		while True:
			linea=file.readline()
			if not linea:break
			if linea.count(">")==1:
				print linea.replace('>','')
			else:
				print linea

	@timethis
	@inverr(str(os.getcwd()+"\cadenaFasta.temp"))
	def invert(self):
		print "inversion de cadena Fasta en proceso"

class FastQRead:
	def __init__(self,direcci):
		self.direccion=direcci
	@timethis
	def read(self):
		file=open(self.direccion,"r")
		out=open(str(os.getcwd()+"\cadenaFastq.temp"),"w+")
		out1=open(str(os.getcwd()+"\FastaQcalidad.temp"),"w+")
		flag=0
		a=0
		flag2=0
		while True:
			cadena=file.read(1)
			if not cadena:break
			if a==0 and cadena=='@':
				a=1
			elif flag==0 and cadena!='+':
				if cadena=='\n':
					flag=1
			elif cadena!='+' and flag==1 and flag2==0:
				out.write(cadena)
				if cadena=='\n':
					flag=0
			elif cadena=='+' and flag==0:
				flag2=1
			elif flag2==1 and a==1:
				out1.write(cadena)
				if cadena=="\n":
					flag=0
					a=0
					flag2=0
		out.close()
		out1.close()
		file.close()
	def prin(self):
		flag=0
		flag2=0
		a=0
		b=0
		file=open(str(self.direccion),"r")
		while True:
			linea=file.readline()
			if not linea:break
			if linea.count("@")==1 and flag==0:
				flag=1
				print linea.replace('@','')
			elif flag==1 and linea.count("+")==0 and flag2==0:
				a+=len(linea)
				print linea
			elif linea.startswith('+') and flag2==0 and flag==1:
				flag2=1
			elif flag2==1:
				b+=len(linea)
				if b==a:
					print linea
					flag=0
					flag2=0
					a=0
					b=0
				else:
					print "Cadenas de calidad y ADN de diferente tamaño"
					break
	@timethis
	@inverr(str(os.getcwd()+"\cadenaFastq.temp"))
	def invert(self):
		print "inversion de la cadena FastQ en proceso"
#-------------------------------------------------->Principal<-----------------------------------
fastaN=FastaRead("G:\Bioinformatica\worm.fasta")#direccion archivo fasta
FastaQ=FastQRead("G:\Bioinformatica\sra_data.fastq")#direccion archivo FastQ
#fastaN.prin()
#fastaN.read()
fastaN.invert()
##FastaQ.prin()
#FastaQ.read()
#FastaQ.invert()

