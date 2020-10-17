It's a repository for several homeworks of Netcracker Java course

*Homework #1*: 
  Created simple POJO classes of book, author, employee and basic geometrical figures, added methods of calculating area and perimeter of these figures. Each class consists of       constructor, getters, setters and overriden hashCode(), equals() and toString() methods. I tested all classes in Main class
*Homework #2*:
  Created POJOs of several objects: 
    - Ball object can be created using fields of ball centre's coordinates, radius, speed and direction(degrees). It contains several methods: move ball in the direction with         current speed, direction can be reflected horizontally or vertically;
    - Complex class contains fields of real and imaginary parts of complex number, several methods for complex numbers like calculating magnitude and argument,                         add/substract/multiply/divide other complex objects(by modyfing current object or creating new one using clone method of Cloneable interface);
    - Polynomial class has one filed of an arrays of polynomial coeffs and several methods to operate polynomial objects: getDegree, add and modify another polynomial number;
    - Container class can represent a rectangle-container with coordinates of 2 vertexes(container actually has 4 parameters: x and y coordinates of one vertex, width and length),     the class has also .collides() method which detects if Ball is inscribed in container(requires Ball objects as parameter) 
  Main class contains testing of all classes
  
