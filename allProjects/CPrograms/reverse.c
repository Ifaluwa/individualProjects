#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#define MAX_SIZE 256

void string_reverse1(char*);
char *string_reverse2(const char*);

void string_reverse1(char * string)
{
	char temp;
    char * end;
    end =  string + strlen(string)-1;
    while(end > string){
        temp = *end;
        *end = *string;
        *string = temp;
        string++;
        end--;
    } 
}


char *string_reverse2(const char *string)
{
    int len = strlen(string);
 	static char nString[MAX_SIZE];
    int i,j;

    for(i = 0, j = len - 1; i < len; i++, j--)
    {
    	nString[i] = string[j];
    }
    return nString;

}


int main()
{
	char string[] = "foobar";
    string_reverse1(string);
    printf("%s\n", string_reverse2(string));

}