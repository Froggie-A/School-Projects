import java.util.Scanner;
import java.util.Random;

public class RPGsim {
	public static void main(String[] args) {
		
	System.out.println("Start Fight!");
	
//Values
	int playerHealth = 100;
	int goblinHealth = 80;
	int mana = 50;
	String attack = null;
	int damage =0;
	int baMin = 5;
	int baMax = 11;
	int fireMin = 10;
	int fireMax = 26;
	int healMin = 20;
	int healMax = 31;
	
	
	
	
//Probability Stuff
	Random myRand = new Random();
	int gobBase1=myRand.nextInt(0,101);
	int gobBase2=myRand.nextInt(0,101);

	
	
	
	
	
	
	while(!((playerHealth <= 0)|| (goblinHealth <= 0))){
		
		System.out.printf("Player HP: %d/100, MP: %d/50 \n", playerHealth, mana);
		System.out.printf("Goblin HP: %d/80 \n", goblinHealth);
		System.out.println("Choose Action: \n 1: Basic Action \n 2: Fireball \n 3: Heal \n 4: Empower \n 5: Flee");
		Scanner numChoice = new Scanner(System.in);
		int baBase = myRand.nextInt(100);
		int gobMisses =0;
		int gobDamage1=0;
		int gobDamage2=0;
		int gobTurns=0;
		int gobAttack1 =0;
		int gobAttack2 =0;
		
		
		boolean check = numChoice.hasNextInt();
		
		if(!check) {
        	System.out.println("Invalid input. Restart fight.");
        	break;
		}
		
		int inputNum = numChoice.nextInt();
	
		damage = myRand.nextInt(baMin,baMax);

		
		
		while(inputNum <1 || inputNum >5 ) {
			System.out.println("Pick one of the power numbers shown above.");
			inputNum = numChoice.nextInt();
		}
		
//Basic Attack
		if(inputNum == 1) {
				attack = "basic attack";
				
				
				if(baBase <=80) {
				
				goblinHealth -= damage;
				System.out.printf("Player used %s! It did %d damage to the goblin! \n",attack,damage);
			}
				else if(baBase >80) {
					System.out.printf("Player used %s! Attack missed. \n",attack);
				}
			}
		
			
			
//Fireball
			if (inputNum==2) {
				attack = "fireball";
				
				
				if(mana >= 6) {
				mana -= 6;
				damage = myRand.nextInt(fireMin,fireMax);
				goblinHealth -= damage;
				System.out.printf("Player used %s! It did %d damage to the goblin! \n",attack,damage);
			}
				else {
					System.out.printf("Player used %s! Attack failed. Not enough mana. \n",attack);
				}
			}
		
			
			
//Heal
			if(inputNum ==3) {
				attack = "heal";
				int heals = myRand.nextInt (healMin,healMax);
				
				if(mana >= 8) {
					if(playerHealth + heals <100) {
						mana -= 8;
						playerHealth += heals;
						System.out.printf("Player used %s! Player healed %d health! \n",attack,heals);
					}

				else if(playerHealth +heals >=100) {
					mana -= 8;
					heals = 100-playerHealth;
					System.out.printf("Player used %s! Player healed %d health! \n",attack,heals);
					playerHealth = heals +playerHealth;
				}
					}
					else{
					System.out.printf("Player used %s! Attack failed. Not enough mana. \n",attack);

			}
			
				}
			
//Empower
			if(inputNum ==4) {
				attack = "empower";
				
				if(mana >= 10) {
				mana -= 10;
					baMin ++;
					baMax = baMax+2;
					fireMin ++;
					fireMax = fireMax +2;
					healMin ++;
					healMax = healMax+2;	
					System.out.printf("Player used %s! Boosting all powers. \n",attack);

			}
				else {
					System.out.printf("Player used %s! Spell failed. Not enough mana. \n",attack);
				}
			}
				
				
				
//Flee
			if(inputNum ==5) {
				System.out.println("Player has fled from the fight.");
				break;
			}
	
	
	
			
//Goblin Damage
			
		System.out.print("Goblin attacked player! ");
		
			gobBase1=myRand.nextInt(0,101);
			gobDamage1= myRand.nextInt(3,8);
		
		
			gobBase2=myRand.nextInt(0,101);
			gobDamage2= myRand.nextInt(3,8);

			
			
		if(gobTurns==0) {
			gobAttack1 = gobDamage1;
			if(gobBase1 < 50) {
				System.out.printf("First hit lands for %d damage! ",gobAttack1);
				
				}
				
			if(gobBase1 > 50) {
					gobMisses ++;
					gobAttack1=0;
			}
			gobTurns ++;
		}
		
		if(gobTurns==1 && gobBase2 > 50) {
			gobMisses ++;
			gobAttack2=0;
		}
		
		if(gobMisses==1 && gobBase1 > 50) {
			System.out.print("First hit misses. ");
		}
			
		if(gobTurns==1 && gobBase2 < 50 ) {
			gobAttack2 = gobDamage2;
		System.out.printf("Second hit lands for %d damage! \n",gobDamage2);
		}
		
		if(gobMisses ==1 && gobBase2 > 50 ) {
		System.out.print("Second hit misses. \n");
		}
		
		if(gobMisses ==2) {
		System.out.print("Both attacks missed. \n");
		}
				

		if(gobTurns >0) {
			gobTurns =0;
		}
			
		
		if(gobMisses >0) {
			gobMisses =0;
		}
		
			playerHealth = playerHealth-(gobAttack1+ gobAttack2);		
			
		

			}
	
	if(playerHealth < 0 && goblinHealth <0) {
		System.out.println("Both parties have been defeated.");
	}

	else if(playerHealth<0) {
		System.out.println("Player has been defeated.");
		
	}
	
	else if(goblinHealth <0) {
		System.out.println("Golbin has been defeated.");
		
	}
	
	
	}
}

	
	
	

