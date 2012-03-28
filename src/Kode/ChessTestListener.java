/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kode;

/**
 *
 * @author Henrik
 */
public class ChessTestListener implements ChessListener {
    public void sjakkReceived(ChessEvent event) {
        if( event.lag() == 1 )
        {
            System.out.println( "Sun is shining!" );
        }
        else if( event.lag() == 2 )
        {
            System.out.println( "Cloudy Skies!" );
        }
        else
        {
            System.out.println( "Lightning rains from the heavens!" );
        }
    }
}    