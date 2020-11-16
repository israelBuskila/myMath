myMath
In this project we had to build a monom that could do things like add another monom,
derivative of a monom, multiply a monom, and find f(x). In the Polynom class needed to build
a list of monoms and create similar to the functions in the monom class. In addition, we
created functions such as add another monom to the list, find an area using Riemann's
Integral, subtract two polynoms, find a root f(x)=0, to check if a polynom is empty, and so on.
We will explain about all of the function below:
**********//Class Monom //**********
#Note: a legal Monom is a Monom where the coefficient is Not zero. or else the Monom will
not be created and an error will be thrown!
#Note2: The power of a Monom has to be greater or equal to zero. or else an error will be
thrown and the Monom will not be created!
This class represents a simple "Monom" of shape a*x^b such that b belongs to the N world
(including 0) and a belongs to the R world – {0} (if a is 0 we remove it like it dosen't exist).
see: https://en.wikipedia.org/wiki/Monomial
The class implements functions and supports simple operations as: a constructor, value at x,
derivative, add and multiply
Public Monom(double a, int b)
Construct or to create monom when ( a = coefficient, b = power) Since b is an int we say
b>0 or else the monom is incorrectly implemented.
Value_x (double x)
Y = f(x) - When f represents the current Monom . We want to get the result of putting x in the
function (in the monom) and return the answer.
Derivative
The derivative of a function of a real variable measures the sensitivity to change of the
function value (output value (with respect to a change in its argument (input value . We
used this link: https://en.wikipedia.org/wiki/Derivative, This function will return the new
Monom - Its coefficient and power .
Multiply
This function will multiply two monoms.
We multiply both the monoms 's coefficients and sum up their powers Then we create a new
monom and return it.
Add
This function will add two monoms: If both the monos have the same power - the function
will sum their coefficients. . We check at the Polynom class if the powers are different of not
so we don’t have to do that on the monom class. There is no such a case which the powers
of the monoms is different.
**********//Class Polynom //**********
#Note: as we said in the Monom creation Monoms in the Polynom cannot have a coefficient
equal to zero or a power smaller then 0.
#Note2: when creating a Polynom using a String you have to put a space between each
monom to the next sign (‘+’ or ‘-’)! if not an error will be thrown!
We defined Polynom to be an ArrayList of Monoms . When you define a new Polynom you
will get an empty Polynom . (In order to add new Monom to the Polynom you will have to use
the function add - Java util function).
Iterator();
Iterator enables you to cycle through a collection, obtaining or removing elements.
ListIterator extends Iterator to allow bidirectional traversal of a list, and the modification of
elements.
Method & Description
1. boolean hasNext()
Returns true if there is a value in the next pocket. Otherwise, returns false.
2. Object next()
Returns the next element.
3. void remove()
Removes the current element.
Copy()
This function will duplicate/clone the Polynom to a new temporary Polynom . In this function
we will be going over all of the current Polynom using iterator and add copy it to the
temporary polynom we careated then we will return it.
isZero
This function will check our Polynom if it’s the zero Polynom which means that all the
monoms's coefficients in the ArrayList are 0. If so it returns true else it returns false.
equals
This function will check if the current Polynom is equal to another polynom we get into the
function. We check that by comparing every two monoms from the
beginning of the polyinoms to their ends. Is they are equal we return true else we return
false.
toString
This function will print our Polynom, by going threw it from the beginning (the first monom in
the current polynom) to the last one.
area
This function will return Riemann Integral using x0, x1, eps .
x0 = the lowest x point
x1 = the highest x point
eps = Size step We will be starting at x0 and every single time we will make steps (eps
size) and by doing that we are getting Trapezoid .
In order to calculate the Trapezoid area, we will take the f(x + (eps/2)) the center of the
Trapezoid which will be the highest and multiply with the base (eps) . By doing that we are
getting the area of all the Trapezoids and by summing them all together we are getting our
area which we will be returning at the end.
