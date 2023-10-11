# Newton report
Author: Satchytan Karalasingham

## UML class diagram

![alt text][uml]

## Execution and Testing
Screenshot demonstrating successful execution and outputs for at least 3 numbers. 

![alt text][screenshot1]
![alt text][screenshot2]
![alt text][screenshot3]


Explain why you chose these numbers for your test.

144 "the bare minimum": First attempted with this number as it had an integer squareroot, is relatively small as a value, and its square root is generally well-known. Therefore 144 presented itself as an excellent starting point for testing as computing its square root is the bare minimum we would expect from our program. Anything less than flawless execution of its comuputation would reveal something is not working correctly in the program.

392847 "a larger but not extreme input": Next tried a larger number and very high precision error request to see if there were any flaws with its computation. One would still expect unproblematic execution with these inputs but they are beyond the square roots people would remember off the top of their heads. This is a more practical use case for a program like this so it was good to test as an input. Also combined this with very small max error to see if any problems arose from it.

36 with extreme initial guess: In the last test we tried a larger value with a very small max error, but we had not yet tested what would occur if the program is given a very last initial guess. I typed in a very large value for initial guess and the program was still able to iterate its way to square root of 36 without issue. This would be a case of edge testing.

To verify that the computations were correct, I began with values I knew the square roots of, e.g. 144, 36, 64, 1 and as I progressed to more extreme inputs, I used a calculator to square the output values to see if it returned the input. While doing all this testing I also ensure that the error was always less than the max error input as well.

[uml]: https://github.com/ensf593-spring-2023/a3-loops-strings-Satchytan/blob/main/Newton-uml_screenshot.png "Newton-uml_screenshot"
[screenshot1]: https://github.com/ensf593-spring-2023/a3-loops-strings-Satchytan/blob/main/NewtonApp_screenshot_1.png "screenshot1"
[screenshot2]: https://github.com/ensf593-spring-2023/a3-loops-strings-Satchytan/blob/main/NewtonApp_screenshot_2.png "screenshot2"
[screenshot3]: https://github.com/ensf593-spring-2023/a3-loops-strings-Satchytan/blob/main/NewtonApp_screenshot_3.png "screenshot3"