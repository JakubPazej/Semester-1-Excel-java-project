/* Eoin McDonough           18241646
 * Jakub Pažej              18260179
 * Aleksander Jakusev       18257038
 */
public class excel_exe{
    
    private String[] sheetNameList;                                                 //I would like an Array
    private int numberOfPages = 0;                                                  //How many Pages
    private int nextPosition = 0;                                                   //Position in array
    private int n = 0;                                                              //Names the sheets
    
    public excel_exe(){
        sheetNameList = new String[256];                                            //Length of array starts at 0 so thats why 255
        while (numberOfPages < 3){
            numberOfPages++;
            n++;
            sheetNameList[nextPosition] = "Sheet" + n;                  //creates Sheet1, 2, 3
            nextPosition++;            
        }
    }
    
    public excel_exe(int howManyPagesUWant){
        sheetNameList = new String[256];                                            //Length of array starts at 0 so thats why 255
        numberOfPages = 1;
        nextPosition = 1;
        n = 1;
        sheetNameList[0] = "Sheet" + numberOfPages;
        while (numberOfPages != howManyPagesUWant){
            if (numberOfPages < howManyPagesUWant){
                numberOfPages++;
                n++;
                sheetNameList[nextPosition] = "Sheet" + n;
                nextPosition++;                 
            }else if (numberOfPages > howManyPagesUWant){
                System.out.println("There always must be at least one sheet.");
            }
        }
    }   
    
    public boolean add(){
        if (nextPosition == 256){
            return false;
        } else {
            numberOfPages++;
            n++;
            sheetNameList[nextPosition] = "Sheet" + n;                                        
            nextPosition++;            
            return true;
        }
    }
    
    public boolean add(String Name){
        int p;
        for(p = 0; p < nextPosition; p++) {
            if(sheetNameList[p].compareToIgnoreCase(Name) == 0){
                return false;                
            }
        }
        if(nextPosition == 256){
            return false;
        } else {
            numberOfPages++;
            n++;
            sheetNameList[nextPosition] = Name;                                     
            nextPosition++;
            return true;
        }   
    }
    
    public int remove(String sheetName){
        int i ;
        for(i = 0; i < nextPosition - 1; i++) {
            if(sheetNameList[i].compareToIgnoreCase(sheetName) == 0){
                sheetNameList[i] = "";
                int j = i;
                if ( i < numberOfPages ){
                    while ( i < numberOfPages ){
                        sheetNameList[i] = sheetNameList[i+1];
                        i++;                        
                    }
                    numberOfPages--;
                    nextPosition--;
                    return j;
                }            
            }
        }
        return -1;
    }  
    
    public String remove(int index){
        if(numberOfPages != 1) {
            if(index <= numberOfPages){
                String gibmarksboss = sheetNameList[index];
                sheetNameList[index] = "";
                while ( index < numberOfPages ){
                        sheetNameList[index] = sheetNameList[index+1];
                        index++;                        
                }
                numberOfPages--;
                nextPosition--;
                return gibmarksboss;
            }else if (index > numberOfPages){
                return null;
            }
        }
        return null;        
    }
    
    public int move(String from, String to, boolean before){
        String storage = "";
        int j, k, sInt1,sInt2;
        sInt1 =0;
        sInt2 =0;
        for(j = 0; j < nextPosition; j++) {
            if(sheetNameList[j].compareToIgnoreCase(from) == 0) {
                storage = sheetNameList[j];
                sheetNameList[j] = "";
                sInt1 = j;         
            }
        }
        for(k = 0; k < nextPosition; k++) {
            if(sheetNameList[k].compareToIgnoreCase(to) == 0) {         
                sInt2=k;
            }
        }
        if(sInt1 == 0 || sInt2 == 0) {
            return -1;
        }
        if(before == false) {
            if( sInt1 - sInt2 > 0) {                //right plus on numbers between
                 while ( sInt1 != sInt2 ){
                     sheetNameList[sInt1] = sheetNameList[sInt1-1];
                     sInt1--;                        
                 }
                 sheetNameList[sInt2 + 1] = storage;
                 return sInt2 + 1;
            }else if ( sInt1 - sInt2 < 0){          //left minus on numbers betwe3n
                 while (sInt1 != sInt2 ){
                     sheetNameList[sInt1] = sheetNameList[sInt1+1];
                     sInt1++;                        
                 }
                 sheetNameList[sInt2] = storage;
                 return sInt2;
            }   
        }else if(before == true) {
            if( sInt1 - sInt2 > 0) {                //right plus on numbers between
                 while ( sInt1 !=sInt2 ){
                     sheetNameList[sInt1] = sheetNameList[sInt1-1];
                     sInt1--;                        
                 }
                 sheetNameList[sInt2] = storage;
                 return sInt2;
            }else if ( sInt1 - sInt2 < 0){          //left minus on numbers betwe3n
                    while ( sInt1  != sInt2  ){
                     sheetNameList[sInt1] = sheetNameList[sInt1+1];
                     sInt1++;                        
                 }
                 sheetNameList[sInt2-1] = storage;
                 return sInt2;
                }
        }  
        return -1;
    }
   
    public String move(int from, int to, boolean before){
        String storage =sheetNameList[from];
        if(from == 0 || to == 0) {
            return null;
        }
        if(before == false) {
            if( from - to > 0) {                //right plus on numbers between
                 while ( from != to ){
                     sheetNameList[from] = sheetNameList[from-1];
                     from--;                        
                 }
                 sheetNameList[to + 1] = storage;
                 return storage;
            }else if ( from - to < 0){          //left minus on numbers betwe3n
                 while (from != to ){
                     sheetNameList[from] = sheetNameList[from+1];
                     from++;                        
                 }
                 sheetNameList[to] = storage;
                 return storage;
            }   
        }else if(before == true) {
            if( from - to > 0) {                //right plus on numbers between
                 while ( from !=to ){
                     sheetNameList[from] = sheetNameList[from-1];
                     from--;                        
                 }
                 sheetNameList[to] = storage;
                 return storage;
            }else if ( from - to < 0){          //left minus on numbers betwe3n
                    while ( from  != to  ){
                     sheetNameList[from] = sheetNameList[from+1];
                     from++;                        
                 }
                 sheetNameList[to-1] = storage;
                 return storage;
                }
        }  
        return null;
    }
    
    public String moveToEnd(int from){
        String sleepTightAniki = sheetNameList[from];
        while (from != numberOfPages  ){
             sheetNameList[from] = sheetNameList[from+1];
             from++;
        }
        sheetNameList[numberOfPages -1] = sleepTightAniki;
        return sheetNameList[numberOfPages];
    }
    
    public int moveToEnd(String from){
        int i;
        for(i = 0; i < nextPosition; i++) { 
            if ( sheetNameList[i].compareToIgnoreCase(from) == 0){
                int j=i;
                while (j != numberOfPages  ){
                     sheetNameList[j] = sheetNameList[j+1];
                     j++;
                                           
                }
                sheetNameList[nextPosition -1] = from;
                sheetNameList[numberOfPages] = from;
                return i;
            }
        }
        return -1;
    }
    
    public int rename(String currentName, String newName){
        int i ;
        for(i = 0; i < nextPosition; i++) {            
            if(sheetNameList[i].compareToIgnoreCase(currentName) != 0){
                
            }else if(sheetNameList[i].compareToIgnoreCase(newName) == 0){
                
            }else{
                sheetNameList[i] = newName;
                return i;
            }
        }
        return -1;
    }
        
    public int index(String sheetName){
        int i ;
        for(i = 0; i < nextPosition - 1; i++) {
            if(sheetNameList[i].compareToIgnoreCase(sheetName) == 0){
                return i;
            }
        }
        return -1;
    }  
   
    public String sheetName(int index){        
        int i ;
        for(i = 0; i < nextPosition - 1; i++) {
                return sheetNameList[index];
            }        
        return null;
    }
    
    public void display() {
        int a =0;
        while(a < numberOfPages) {
            System.out.println(sheetNameList[a]);
            a++;
        }
    }

    public int length(){
        return numberOfPages;
    }
}
