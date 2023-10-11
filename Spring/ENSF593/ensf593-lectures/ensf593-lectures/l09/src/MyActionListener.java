class MActionEvent{}

interface MActionListener{
	public void actionPerformed(MActionEvent e);
}

class GUI implements MActionListener{

	//button.addActionListener(this) //button is-a widget
	
	@Override
	public void actionPerformed(MActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}

public class MyActionListener {

	public static void main(String[] args) {
		while(true) {
			Point2D p = waitForMouseClick();
			for(Widget w: allWidgets) {
				if(w.hasPoint(p)) {
					w.getActionListener().actionPerformed(new MActionEvent(w));
				}; //was mouse clicked on you widget
				
			}
		}

	}

}
