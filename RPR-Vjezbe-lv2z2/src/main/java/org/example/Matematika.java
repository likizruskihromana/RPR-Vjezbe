package org.example;

import static java.lang.Math.pow;

public class Matematika {
        public static int faktorijel(int broj){
            int i,fact=1;
            for(i=1;i<=broj;i++){
                fact=fact*i;
            }
            return fact;
        }
        public static double sinus(double x){
            double sinus=0;
            int sklj=0;
            for (int i=1;i<=20;i+=2){
                if (sklj%2==0) {sinus-=pow(x,i)/faktorijel(i);}
                    else sinus+=pow(x,i)/faktorijel(i);
                    sklj++;
            }
            return sinus;
        }
    }

