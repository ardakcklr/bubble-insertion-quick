import java.util.Random;

public class Sorting {
    int dizi[];
    public Sorting(int elemanSayisi) {
        dizi = new int[elemanSayisi];
        Random random = new Random();
        for(int i = 0; i < elemanSayisi; i++)
            dizi[i] = random.nextInt(10000);
        
        yazdir(dizi);
        
        int bubbleSortDizi[] = dizi;
        int quickSortDizi[] = dizi;
        int InsertionSortDizi[] = dizi;
        
        BubbleSort b = new BubbleSort();
        QuickSort q = new QuickSort();
        InsertionSort i = new InsertionSort();
        b.sort(bubbleSortDizi);
        b.yazdir(bubbleSortDizi);
        q.sort(quickSortDizi, 0, quickSortDizi.length-1);
        q.yazdir(quickSortDizi);
        i.sort(InsertionSortDizi);
        i.yazdir(InsertionSortDizi);
        
    }
    public void yazdir(int d[]){
            System.out.print("\nDizi: ");
            for(int i = 0; i < d.length; i++){
                System.out.print(d[i]+" ");
            }
            System.out.print("\b\n");
    }
    public class BubbleSort{
        long baslangıcZamanı,bitisZamani,gecenSure;
        public BubbleSort(){
            
        }
        public void sort(int d[]){
            baslangıcZamanı = System.nanoTime();
            for(int i = 0; i < d.length-1; i++){
                for(int j = 0; j < d.length - i - 1; j++){
                    if(d[j] > d[j+1]){
                        int temp = d[j];
                        d[j] = d[j+1];
                        d[j+1] = temp;
                    }
                }
            }
            bitisZamani = System.nanoTime();
            gecenSure = (bitisZamani - baslangıcZamanı);
        }
        public void yazdir(int d[]){
            System.out.print("\nBubble Sort: ");
            for(int i = 0; i < d.length; i++){
                System.out.print(d[i]+" ");
            }
            System.out.print("\b");
            System.out.println("\nÇalışma süresi: "+ gecenSure + " nano saniye");
        }
    }
    
    public class QuickSort{
        long baslangıcZamanı,bitisZamani,gecenSure;
        public QuickSort(){
            
        }
        public void sort(int d[],int baslangic,int bitis){
            baslangıcZamanı = System.nanoTime();
            if(baslangic < bitis){
                int pi = partition(d,baslangic,bitis);
                sort(d,baslangic,pi-1);
                sort(d,pi+1,bitis);
            }
            bitisZamani = System.nanoTime();
            gecenSure = (bitisZamani - baslangıcZamanı);
        }
        int partition(int d[], int bas, int bit){
            int pivot = d[bit];
            int i = bas-1;
            for(int j = bas; j < bit; j++){
                if(d[j] < pivot){
                    i++;
                    int temp = d[i]; 
                    d[i] = d[j]; 
                    d[j] = temp; 
                }
            }
            int temp = d[i+1]; 
            d[i+1] = d[bit]; 
            d[bit] = temp;
            return i+1;            
        }
        public void yazdir(int d[]){
            System.out.print("\nQuick Sort: ");
            for(int i = 0; i < d.length; i++){
                System.out.print(d[i]+" ");
            }
            System.out.print("\b");
            System.out.println("\nÇalışma süresi: "+ gecenSure + " nano saniye");
        }
    }
    
    public class InsertionSort{
        long baslangıcZamanı,bitisZamani,gecenSure;
        public InsertionSort(){
            
        }
        public void sort(int d[]){
            baslangıcZamanı = System.nanoTime();
            for(int i = 1; i < d.length; ++i){
                int key = d[i];
                int j = i - 1;
                while(j >= 0 && d[j] >key){
                    d[j+1] = d[j];
                    j--;
                }
                d[j+1] = key;
            }
            bitisZamani = System.nanoTime();
            gecenSure = (bitisZamani - baslangıcZamanı);
        }
        public void yazdir(int d[]){
            System.out.print("\nInsertionSort: ");
            for(int i = 0; i < d.length; i++){
                System.out.print(d[i]+" ");
            }
            System.out.print("\b");
            System.out.println("\nÇalışma süresi: "+ gecenSure + " nano saniye");
        }
    }
}
