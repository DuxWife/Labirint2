package labirint2;
import java.io.*;
public class Labirint2 {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int m,n,i,j,x=0,y=0,h=1,q=1,z=0,k;
      System.out.print("Введите количество строк:");
      m=Integer.parseInt(br.readLine ());
      System.out.print("Введите количество столбцов:");
      n=Integer.parseInt(br.readLine ());
     int [][] l=new int[m][n];
      for (i=0;i<m;i++) 
          for (j=0;j<n;j++){
              System.out.print("("+(i+1)+","+(j+1)+")=");
              l[i][j]=Integer.parseInt(br.readLine ());
          } 
      System.out.print("k=");
      k=Integer.parseInt(br.readLine ());
      int [][] s=new int[m][n];
      for (i=0;i<m;i++) for (j=0;j<n;j++) s[i][j]=0;
      s[0][0]=1;
      String [] p=new String [m*n];
      for (i=0;i<m*n;i++) p[i]="";
     while ((x!=m-1|y!=n-1)&h!=0) {
         q=h;
         if (y!=n-1&&s[x][y+1]==0&&Math.abs(l[x][y]-l[x][y+1])<=k){
             h++;y++;
             s[x][y]=h;  
             p[z]="вправо ";z++;
         }else {
             if (x!=m-1&&s[x+1][y]==0&&Math.abs(l[x][y]-l[x+1][y])<=k){
                 h++;x++;
                 s[x][y]=h;
                p[z]="вниз " ;z++;
             }else{
                 if (y!=0&&s[x][y-1]==0&&Math.abs(l[x][y]-l[x][y-1])<=k){
                     h++;y--;
                     s[x][y]=h;
                     p[z]="влево ";z++;
                 }else {
                     if (x!=0&&s[x-1][y]==0&&Math.abs(l[x][y]-l[x-1][y])<=k){
                         h++;x--;
                         s[x][y]=h;
                         p[z]="вверх ";z++;
                     }
                 }
             }
         }
         if (q==h){
             s[x][y]=-1;h--;
             z--; 
             if (y!=0&&s[x][y-1]==h) y--;
             else {
                 if(x!=0&&s[x-1][y]==h) x--;
                 else{
                     if (y!=n-1&&s[x][y+1]==h) y++;
                     else{
                         if (x!=m-1&&s[x+1][y]==h) x++;
                     }
                 }
             }
         }
     }
      for (i=0;i<m;i++) {
          for (j=0;j<n;j++){
              System.out.print(l[i][j]+" ");
          }  
          System.out.println("");
     }
     if (h==0) System.out.println("Пути нет");
     else for (i=0;i<z;i++) System.out.print(p[i]);
    }    
}