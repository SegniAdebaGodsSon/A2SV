function twoStacks(x, a, b) {
    /*
     * Write your code here.
     */
    let s1 = 0, s2 = 0, count = 0, sum = 0;
    while((s1<a.length || s2<b.length) && sum < x){
        if(s1<a.length && s2<b.length){
            if(a[s1] >= b[s2]){
                sum += b[s2];
                s2++;
                count++;
            }else{
                sum += a[s1];
                s1++;
                count++;
            }
            
        }else if(s1<a.length){
            sum += a[s1];
            s1++;
            count++;
        }else{
            sum += b[s2];
            s2++;
            count++;
        }
    }
   return count-1;
}

