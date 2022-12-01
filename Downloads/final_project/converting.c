//CONVERTING MODULE SOURCE
#define _CRT_SECURE_NO_WARNINGS
#define BUFFER_SIZE 80
#include "converting.h"

//Function converts a string of numeric characters into an integer
//Function returns the converted integer number from the numeric string input by the user
void converting(void) {
/* Version 1 */
    printf("*** Start of Converting Strings to int Demo ***\n");
    char intString[BUFFER_SIZE]; //intString is a string that the user input from the keyboard that will be converted into integer
    int intNumber;
    do { //Let the loop runs at least 1 time for the program to take and validate user input, which guarantees the beginning of execution
        printf("Type an int numeric string (q - to quit):\n");
        fgets(intString, BUFFER_SIZE, stdin); //Prompt the user to input a string from the keyboard
        intString[strlen(intString) - 1] = '\0'; //Insert the null terminator at the end of string to ensure the string terminates correctly
        if (strcmp(intString, "q") != 0) { //If the user does not type "q" as input, execute the code block below 
            intNumber = atoi(intString); //Convert the first portion of intString that has numeric values into integer
            printf("Converted number is %d\n", intNumber);
        }
    } while (strcmp(intString, "q") != 0); //The termination of the infinite loop is determined when the user type "q"
    printf("*** End of Converting Strings to int Demo ***\n\n"); //Show the ending message to the user
}

/* Version 2 */
//>> insert here


/* Version 3 */
//>> insert here



