import operator

listOfNumbers = []
ops = {'+' : operator.add, '-' : operator.sub, '*' : operator.mul, '/' : operator.truediv, '%' : operator.mod, '^' : operator.xor,}


print('Welcome to the EasyCalcu!\nEvery numbers and operator seperate by Enter \nUse E to close an aplication')

while True:
  a = input()
  if a.isdigit():
    listOfNumbers.append(int(a))
  else:
    if a == 'E':
      break
    else:
      task = a
  if len(listOfNumbers) == 2:
    print('= ' , ops[task](listOfNumbers[0],listOfNumbers[1]))
    listOfNumbers.clear()
  
