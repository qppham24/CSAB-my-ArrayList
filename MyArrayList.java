    //create your own version of the ArrayList by completing this class definition
	 //look in ListInterface to see what methods you need to create
    
    public class MyArrayList<anyType> implements ListInterface<anyType>
   {
      private Object[] list;		//stores the actual elements
      private int numElements;	//used to keep track of the number of valid elements in the list
   	
       public MyArrayList()
      {
         list = new Object[10];	//start with a buffer size of 10
         numElements = 0;
      }
   
       private void doubleCapacity()	//private because this is a helper method that need not be used outside of the class
      {
      	//make list twice as big, i.e. given [A, B, C, null], results with [A, B, C, null, null, null, null, null]
      	//to be used if we add an element that would be over the capacity of list
         Object[] r = new Object[numElements*2];
         for (int i=0; i<numElements; i++) {
            r[i] = list[i];
         }
         list = r;
      }
      
       private void cutCapacity()	//private because this is a helper method that need not be used outside of the class
      {
      	//make list half as big, i.e. given [A, B, C, null, null, null, null, null], results with [A, B, C, null]
      	//to be used if after removing an element, we have less than 1/3 of the capacity of list being used
         //dont cut below 10
         Object[] r;
         if (list.length/2 < 10)
            r = new Object[10];
         else
            r = new Object[list.length/2];
            
         for (int i=0; i<numElements; i++) {
            r[i] = list[i];
         }
         list = r;
      }
      
       public String toString()
      {
         String ans = "[";
      	//add all array elements with a comma separating each, i.e. [A, B, C] 
         for (int i=0; i<numElements; i++) {
            ans += list[i];
            if (i<numElements-1)
               ans += ", ";
         }
         return ans + "]";
      }
      
      public boolean add(anyType x){
         if (numElements >= list.length)
            doubleCapacity();
         list[numElements] = x;
         numElements++;
         return true;
      }
      
      public boolean add(int index, anyType x) {
         if (numElements >= list.length)
            doubleCapacity();
         numElements++;
         for (int i=numElements; i>index; i--) {
            list[i] = list[i-1];
         }
         list[index] = x;
         return true;
      }
      
      public int size() {
         return numElements;
      }
      
      public anyType set(int index, anyType x) {
         Object old = list[index];
         list[index] = x;
         return (anyType)old;
      }
      
      public anyType get(int index) {
         return (anyType)list[index];
      }
      
      public anyType remove(int index) {
         Object old = list[index];
         numElements--;
         for (int i=index; i<numElements; i++) {
            list[i] = list[i+1];
         }
         list[numElements] = null;
         if (numElements <= list.length/2)
            cutCapacity();
         return (anyType)old;
      }
   }