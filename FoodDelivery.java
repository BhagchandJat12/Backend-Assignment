import java.util.LinkedList;
import java.util.Scanner;
class Executive{
    int Executive_id;
    boolean Is_Hired;
    boolean Is_Accepted_task;
    boolean Is_complete_task;
    boolean Is_Released;
    int assigned_task;
    int Completed_task;
    int  total_task;
    LinkedList<String>   task=new LinkedList<>();
     
    public void task_id(String task_id){
       
        task.add(task_id);
        this.total_task=task.size();
    }

    int gettotal_task(){
        return total_task;
    }

public Executive(){

}

 
    public Executive(int Executive_id,boolean Hired,boolean Released,int assigned_task,int completed_task){
        this.Executive_id=Executive_id;
        this.Is_Hired=Hired;
        this.Is_Released=Released;
        this.assigned_task=assigned_task;
        this.Completed_task=completed_task;
    }

    int getExecutive_id(){
        return Executive_id;
    }
   

    boolean getIs_Accepted_task(){
        return Is_Accepted_task;
    }

    boolean getIs_complete_task(){
        return Is_complete_task;
    }

    boolean getIs_Released(){
        return Is_Released;
    }

    
     int getassigned_task(){
        return assigned_task;
    }
void setIs_Hired(boolean Is_Hired){
    this.Is_Hired=Is_Hired;
}

void setIsReleased(boolean Is_Released){
   this.Is_Released=Is_Released;
}
    void setIs_Accepted_task(boolean Is_Accepted_task){
         this.Is_Accepted_task=Is_Accepted_task;
    }

     void setIs_complete_task(boolean Is_complete_task){
         this.Is_complete_task=Is_complete_task;
    }


     void setAssigned_task(int assigned){
        this.assigned_task=assigned;
    }

  
}
class FoodDelivery
{

   
   
 static void display(Executive e[]){
     try{
   
Scanner sc=new Scanner(System.in);
    System.out.println("");
           System.out.println("a) Hired/ Released  Executive");
           for(int i=0;i<e.length;i++){
               int n=i+1;
                   if(e[i].Is_Hired==true){
                       System.out.println("executive "+n+" is hired");
                   }
                   if(e[i].Is_Released==true){
                       System.out.println("executive "+n+" is released");
                   }
           }
           System.out.println("");
           System.out.println("b) Accepted/ Completed  Executive");
           for(int i=0;i<5;i++){
               int x=i+1;
               if(e[i].Is_Accepted_task==true){
                   e[i].Is_Accepted_task=false;
                   System.out.println("executive "+x+" was assigned a task");
               }
               if(e[i].Is_complete_task==true){
                   e[i].Is_complete_task=false;
                   System.out.println("executive "+x+"  completed a task");
               }
       }
           System.out.println("c) List of  Executives with assigned no. of tasks");
           for(int i=0;i<e.length;i++){
               int n=i+1;
               if(e[i].gettotal_task()==0)
                   continue;
               else
                   System.out.println("executive "+n+" has "+e[i].gettotal_task()+" tasks");
           }
           
        
           System.out.println("Do you want to exit for exit Enter 'exit' else 'continue'");
           String s=sc.nextLine();
           if(s.equals("exit")){
               System.exit(0);
               
           }
          
           hired_released(e);
           
        }catch(Exception ee){
            ee.printStackTrace();
        }
   
           
       }
   
       static void  add_task(Executive e[]){
           try{
        Scanner scr = new Scanner(System.in);
            System.out.println("Add task  here (String values)");
            String s=scr.nextLine();
           
// Assign Task to Executive
              for(int i=0; i<e.length;i++){
                  if(e[i].Is_Hired==true && e[i].gettotal_task()<e.length ){
                    e[i].setIs_Accepted_task(true);
                    e[i].assigned_task++;
                    e[i].task_id(s);
                      break;
                  }
              }
        
   // Set which executive completed task
         System.out.println("Enter which Executive completed a task(executive Id Integer)");
         int complete_ex_id=scr.nextInt();
         for(int i=0; i<e.length;i++){
            if(i==complete_ex_id-1) {
                if(e[i].gettotal_task()>e[i].Completed_task && e[i].Is_Released==false){
                e[i].setIs_complete_task(true);
                   e[i].Completed_task++;
                break;
                }else{
                    System.out.println("Executive is either Released or No assigned task");
                    break;
                }
            }
        }
        
      
      display(e);
    }catch(Exception ee){
        ee.printStackTrace();
    }
       
              
   
       }
    
        
      static  void hired_released(Executive e[]){
            try{
Scanner sc = new Scanner(System.in);

//Which Executive is hired
    System.out.println("Enter which executive is hired (Only Integer values)");
       int ex_id=sc.nextInt();
       for(int i=0; i<e.length;i++){
        if(i==ex_id-1 && e[i].Is_Hired==false) {
            
            e[i].setIs_Hired(true);
            break;
        }else if(i!=ex_id){
            continue;
        }else{
            System.out.println("Executive is already hired");
            break;
        }
    }
       
    
    
      for(int i=0; i<e.length;i++){
          int completed=e[i].Completed_task;
        if(e[i].Is_Hired==true && e[i].gettotal_task()==completed && completed==e.length ){
            
            e[i].setIsReleased(true);
            break;
        }
    }
 
   
      add_task(e); 
    }catch(Exception ee){
        ee.printStackTrace();
    }

          
       }
    
       public static void main(String args[]){
       
        Executive e[]=new Executive[10];
        for(int i=0;i<e.length;i++){
            e[i]=new Executive(i,false, false,0,0);
        }
hired_released(e);
   

    }
}