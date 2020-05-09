import java.util.*;
//import javafx.util.*;
 class vertical{
     static class node{
       String data;
       node left,right;
       node(String data)
        {
          this.data=data;
          left=right=null;
        }
     }
     static node insert(node t,String s1[])
      {
        Queue<node> q=new LinkedList<>();
         t=new node(s1[0]);
           q.add(t);
           node root=q.peek();
          for(int i=1;i<s1.length;i++)
           {
             t=q.poll();
              if(!s1[i].equals("N")&&t.left==null)
                {
                  t.left=new node(s1[i]);
                  q.add(t.left);
                }
                i++;
                if(i>=s1.length)
                 break;
                 if(!s1[i].equals("N")&&t.right==null)
                  {
                    t.right=new node(s1[i]);
                    q.add(t.right);
                  }
           }
           return root;
      }

      static  void preorder(node t){
       //  node t=root;
         if(t!=null)
          {
            System.out.print(t.data+" ");
            preorder(t.left);
            preorder(t.right);
          }
       }
      static Map<Integer,List<String>> mp=new TreeMap<>();
        static void verticalprint(node root,int hd)
         {
           if(root==null)
             return;
              if(!mp.containsKey(hd))
                mp.put(hd,new ArrayList<>());
                mp.get(hd).add(root.data);
               verticalprint(root.left,hd-1);
               verticalprint(root.right,hd+1);

         }

   public static void main(String[] args) {
     Scanner sc=new Scanner(System.in);
     int t=Integer.parseInt(sc.nextLine());
       while(t-->0)
         {
           mp.clear();
           String s=sc.nextLine();
           String s1[]=s.split(" ");
            node root=null;
            root=insert(root,s1);
            //preorder(root);
            verticalprint(root,0);
             for(List<String> li:mp.values())
               {
                 for(int i=0;i<li.size();i++)
                    System.out.print(li.get(i)+" ");
                     System.out.println();
               }

         }
   }
 }
// refer geeks error in this program
//https://www.techiedelight.com/vertical-traversal-binary-tree/
