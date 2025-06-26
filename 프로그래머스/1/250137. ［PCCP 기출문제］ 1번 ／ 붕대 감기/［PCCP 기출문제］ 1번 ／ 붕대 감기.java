class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int maxHealth = health;
        int currentHealth = health;
        int sequence = 0;
        int time = 1;
        int attackIndex = 0;

        while (time <= attacks[attacks.length - 1][0]) {
            if (attackIndex < attacks.length && attacks[attackIndex][0] == time) {
                // 공격 시 회복 X
                currentHealth -= attacks[attackIndex][1];
                sequence = 0;
                attackIndex++;

                if (currentHealth <= 0) return -1;
            } else {
                // 회복 가능
                sequence++;
                currentHealth += bandage[1];
                if (sequence == bandage[0]) {
                    currentHealth += bandage[2];
                    sequence = 0;
                }
                if (currentHealth > maxHealth) currentHealth = maxHealth;
            }

            time++;
        }

        return currentHealth;
    }
}