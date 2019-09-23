package Gamejam;

import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
/**
 * The MainScreen view. 
 * Should be the first thing that pops up when loading the application
 * Should be what is returned to after closing a game.
 * @author Joey McMaster
 *
 */
public class GamejamMainScreen extends BorderPane {
	private GridPane gameselectonboxarea;
	public GamejamMainScreen() {
		super();
		init();
	}
	/**
	 * Inits the Object
	 */
	private void init() {
		this.setTop(_getTop());
	}
	/**
	 * Gets the item that is surposed to be the top most part of the application
	 * This should be the clickable menus that allow the use to log in and adjust their account settings.
	 * @return A Menubar with all the options already added to it.
	 */
	private MenuBar _getTop() {
		MenuBar bar = new MenuBar();
		Menu accountmenu =  new Menu("Accounts");
		MenuItem loginopt = new MenuItem("Log in");
		MenuItem logoutopt = new MenuItem("Log out");
		accountmenu.getItems().addAll(loginopt,logoutopt);
		Menu optionmenu = new Menu("Options");
		bar.getMenus().addAll(accountmenu,optionmenu);
		return bar;
	}
	private GridPane _getCenter() {
		GridPane n = new GridPane();
		gameiconitem[] gamelist = getGameList();
		int y = 0;
		for(int x = 0; x < gamelist.length; x++) {
			Button gamebutton = new Button();
			gamebutton.setGraphic()
		}
		return n;
	}
	/**
	 * Fetches all the games that are implemented
	 */
	private gameiconitem[] getGameList() {
		gameiconitem[] retval = new gameiconitem[1];
		gameiconitem tictactoe = new gameiconitem("Tic-tac-toe","/tictactoeicon.png",0);
		return retval;
	}
	/**
	 * Private class, Holds needed data to produce each button that loads each game.
	 * @author Joey McMaster
	 *
	 */
	private class gameiconitem {
		String gamename;
		String iconfilepath;
		int gameid;
		public gameiconitem(String name, String iconfilepath, int gameid) {
			this.gamename = name;
			this.iconfilepath = iconfilepath;
			this.gameid = gameid;
		}
		public String getName() {
			return gamename;
		}
		public String getIconFilePath() {
			return iconfilepath;
		}
		public int getGameID() {
			return gameid;
		}
	}
}
