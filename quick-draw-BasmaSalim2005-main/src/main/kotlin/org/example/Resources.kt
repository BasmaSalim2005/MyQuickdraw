package org.example

import org.example.game.Difficulty

object Resources {
    val MENU = """

	  Quick Draw

	  Face your opponent and wait for the signal. Once the
	  signal is given, shoot your opponent by pressing [space]
	  before they shoot you. It's all about your reaction time.

	  Choose Your Opponent:
	  [1] Easy....${Difficulty.EASY.milliseconds} milliseconds
	  [2] Medium...${Difficulty.MEDIUM.milliseconds} milliseconds
	  [3] Hard.....${Difficulty.HARD.milliseconds} milliseconds
	  [4] Harder...${Difficulty.HARDER.milliseconds} milliseconds
	  [escape] give up
	"""

    const val WAIT = """

	  Quick Draw
	                                                        
	                                                        
	                                                        
	              _O                          O_            
	             |/|_          wait          _|\|           
	             /\                            /\           
	            /  |                          |  \          
	  ------------------------------------------------------
	"""

    const val FIRE = """

	  Quick Draw
	                                                        
	                         ********                       
	                         * FIRE *                       
	              _O         ********         O_            
	             |/|_                        _|\|           
	             /\          spacebar          /\           
	            /  |                          |  \          
	  ------------------------------------------------------
	"""

    const val LOSE_TOO_SLOW = """

	  Quick Draw
	                                                        
	                                                        
	                                                        
	                                        > ╗__O          
	           //            Too Slow           / \         
	          O/__/\         You Lose          /\           
	               \                          |  \          
	  ------------------------------------------------------
       Play Again [enter] or quit [escape]? 
	"""

    const val LOSE_TOO_FAST = """

	  Quick Draw
	                                                        
	                                                        
	                                                        
	                         Too Fast       > ╗__O          
	           //           You Missed          / \         
	          O/__/\         You Lose          /\           
	               \                          |  \          
	  ------------------------------------------------------
       Play Again [enter] or quit [escape]? 
	"""

    const val WIN = """

	  Quick Draw
	                                                        
	                                                        
	                                                        
	            O__╔ <                                      
	           / \                               \\         
	             /\          You Win          /\__\O        
	            /  |                          /             
	  ------------------------------------------------------
       Play Again [enter] or quit [escape]? 
	"""

    const val SPACE_CODE = 32
    const val ESC_CODE = 27
    const val ENTER_CODE = 13
    const val CODE_1 = 49
    const val CODE_2 = 50
    const val CODE_3 = 51
    const val CODE_4 = 52

    const val WAIT_MIN: Long = 3000
    const val WAIT_MAX: Long = 7000

    const val EASY_TIME: Long = 1500L
    const val MEDIUM_TIME: Long = 1000L
    const val HARD_TIME: Long = 500L
    const val HARDER_TIME: Long = 300L
}
