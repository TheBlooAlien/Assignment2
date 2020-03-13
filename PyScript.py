import os
import subprocess
'''Helper script to automate LSArrayApp and LSBSTApp.'''

def runASArr (fileName):
    file = open('/home/bloo/Assignment1/src/'+fileName, 'r')
    writeFileIns = open('/home/bloo/Assignment1/DataResults/'+fileName+'_ArrIns_DataCount.txt','w')
    writeFileFind = open('/home/bloo/Assignment1/DataResults/'+fileName+'_ArrFind_DataCount.txt','w')

    for line in file:
        lineArr = line.split(" ", 2)
        keyInfo = lineArr[0].split("_")#holds the individual pieces
        key = lineArr[0]

        run = subprocess.check_output("java LSArrayApp "+keyInfo[0]+" "+keyInfo[1]+" "+keyInfo[2]+" "+fileName, shell = True)#prints findCount arr[1], prints length or array arr[2]
        outputStr = (run.decode("utf-8"))
        outputArr = outputStr.split("\n")

        writeFileFind.write(outputArr[1]+"\n")
        writeFileIns.write("0\n")
    
def runLSBST (fileName):
    file = open('/home/bloo/Assignment1/src/'+fileName, 'r')
    writeFileFind = open('/home/bloo/Assignment1/DataResults/'+fileName+'_BSTFind_DataCount.txt','w+')
    writeFileIns = open('/home/bloo/Assignment1/DataResults/'+fileName+'_BSTIns_DataCount.txt','w+')#arr[0] is to fill tree, arr[1] is findcount and arr[2] is printcount
    
    for line in file:
        lineArr = line.split(" ", 2)
        keyInfo = lineArr[0].split("_")#holds the individual pieces
        key = lineArr[0]

        run = subprocess.check_output("java LSBSTApp "+keyInfo[0]+" "+keyInfo[1]+" "+keyInfo[2]+" "+fileName, shell = True)
        outputStr = (run.decode("utf-8"))
        outputArr = outputStr.split("\n")

        
        writeFileFind.write(outputArr[1]+"\n")
        writeFileIns.write(outputArr[2]+"\n")

sysinput = input("Enter file name: ")
runASArr(sysinput)
runLSBST(sysinput)



