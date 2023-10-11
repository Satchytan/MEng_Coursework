ham = [1,2,3]
eggs = "ENSF 592"
spam = ham
foo = spam
foo += foo
bar = eggs[-5]
eggs = "SCHULICH"
spam.append(4)


print(ham)

M = [2,3]
L = []



print(*map(lambda a,b:a+b, range(5), range(10)))


L = [n//2 for n in range(100) if n%10==0]

print(L)