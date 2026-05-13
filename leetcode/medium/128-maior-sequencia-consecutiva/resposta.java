import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

class Solution {
    public int longetConsecutive(int[] nums) {
        Set<Integer> numeros = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toSet());

        int maiorSequencia = 0;
        //percorrer o array
        for(int numero: numeros){
            //verificar em O(1) se existe um valor menor e iniciar uma sequencia
            if ( ! ( numeros.contains(numero - 1) ) ) {
                int sequencia = 1;
                //caso sim
                //verificar em o(1) se existe um valor maior e incrementar +1 na sequencia enquanto existir
                while(numeros.contains(numero + sequencia)) {
                    sequencia++;
                }
                maiorSequencia = Math.max(maiorSequencia, sequencia);
            }
        }
        //retornar maior sequencia
        return maiorSequencia;
    }
}