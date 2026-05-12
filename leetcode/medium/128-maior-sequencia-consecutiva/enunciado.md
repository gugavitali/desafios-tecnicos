# 128. Sequência Consecutiva Mais Longa

**Dificuldade:** Médio

Dado um array de inteiros não classificados `nums`, retorne *o comprimento da maior sequência consecutiva de elementos*.

Você deve escrever um algoritmo que seja executado em tempo `O(n)`.

## Exemplo 1:

**Entrada:** `nums = [100,4,200,1,3,2]`  
**Saída:** `4`  
**Explicação:** A maior sequência consecutiva de elementos é `[1, 2, 3, 4]`. Portanto seu comprimento é de 4.

## Exemplo 2:

**Entrada:** `nums = [0,3,7,2,5,8,4,6,0,1]`  
**Saída:** `9`

## Exemplo 3:

**Entrada:** `nums = [1,0,1,2]`  
**Saída:** `3`

## Restrições:

* `0 <= nums.length <= 10^5`
* `-10^9 <= nums[i] <= 10^9`

## Solução (Java)

```java
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

class Solution {
    public int longestConsecutive(int[] nums) {
        int contador = 0;

        Set<Integer> setNum = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toSet());

        for(int num: setNum) {
            // Verifica se é o início de uma sequência
            if (!setNum.contains(num - 1)) {
                int sequencia = 1;
                while (setNum.contains(num + sequencia)) {
                    sequencia++;
                }
                contador = Math.max(contador, sequencia);
            }
        }
        return contador;
    }
}