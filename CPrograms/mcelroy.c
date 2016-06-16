#include<stdlib.h>
#include<stdio.h>
#include<limits.h>
#include<math.h>
#define SIZE 25

//Function Declaration

int Input(int[] );
int Quantity(int[] , int);
int Funds(int[] , int, int);
int maxAmount(int[], int, int);
int minAmount(int[], int, int);
int firstSum(int[], int);
void duplicate(int, int[], int[]);
void result(int, int, int, int, int);

int main()
{
  int value; 
  int array[SIZE];
  int array2[SIZE]; //duplicate array
  int quantity;
  int funds;
  int maxCombination;
  int minCombination;
  int firstDesired;

//Function Call
value = Input(array); //value is number of item prices input
duplicate(value, array, array2); //creates a duplicate array to be used to check for min combination
quantity = Quantity(array, value); //gets number of items wanted
funds = Funds(array, value, quantity); //gets funds available
firstDesired = firstSum(array, quantity);
maxCombination = maxAmount(array, value, quantity); //finds max combination
minCombination = minAmount(array2, value, quantity);
result(funds, maxCombination, firstDesired, minCombination, quantity);
  return 0;
}


int Input(int array[])
{
  int value = 0;

  printf("Enter item price values: ");
  do
  {
    scanf("%d", &array[value]);
    value++;
  }while((array[value - 1] != -1) && (value < SIZE));

  return value - 1;
}


int Quantity(int array[], int value)
{
  int quantity = 0;

  do
  {
    printf("Enter the quantity of desired items: ");
    scanf("%d", &quantity);

    if(quantity > (value)){
      printf("\nError! Quantity may not exceed the number of items available!!\n\n");
    }

  }while(quantity > (value));

  return quantity;
}

int Funds(int array[], int value, int quantity)
{
  int funds = 0;

  do
  {
    printf("Enter available funds: ");
    scanf("%d", &funds);
    
    if(funds < 1){
      printf("\nError! Available funds must be non-negative!!\n\n");
    }

  }while(funds < 1);

  return funds;
}

int maxAmount(int array[], int value, int quantity)
{
  int maxSum = 0;
  for(int i = 0; i < quantity; i++){
    int max = 0;
    int rem = -1;
    for(int k = 0; k < value; k++){
      if(array[k] > max){
        max = array[k];
        rem = k;
      }
    }
    array[rem] = 0;
    maxSum += max;
  }
  return maxSum;
}

int minAmount(int array[], int value, int quantity)
{
  int minSum = 0;
  for(int i = 0; i < quantity; i++){
    int min = INT_MAX;
    int rem = -1;
    for(int k = 0; k < value; k++){
      if(array[k] < min){
        min = array[k];
        rem = k;
      }
    }
    array[rem] = INT_MAX;
    minSum += min;
  }
  return minSum;
}

int firstSum(int array[], int quantity)
{
  int sum = 0;
  for(int k = 0; k < quantity; k++){
    sum += array[k] ; 
  }
  return sum;
}

void duplicate(int value, int array[], int array2[]){
  for(int i = 0; i < value; i++){
    array2[i] = array[i];
  }
}

void result(int funds, int max, int desired, int min, int quantity){
  if (max < funds){
    printf("\nAll unique %d combination of items can be purchased.\n\n", quantity);
  } else if(desired < funds){
    printf("\nThe first %d items can be purchased.\n\n", quantity);
  } else if(min < funds){
    printf("\nThere are at least %d items that can be purchased\n\n", quantity);
  } else {
    printf("\nno combinations possible\n\n");
  }

}
