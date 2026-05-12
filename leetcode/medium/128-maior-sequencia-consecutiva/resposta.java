class Solution {
    public int longestConsecutive(int[] nums) {
        int contador = 0;

        Set<Integer> setNum = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toSet());

        for(int num: setNum) {
            if ( ! (setNum.contains( num - 1 ) ) ) {
                int sequencia = 1;
                while ( setNum.contains( num + sequencia ) ) {
                    sequencia++;
                }
                contador = Math.max(contador, sequencia);
            }
        }
        return contador;
    }
}