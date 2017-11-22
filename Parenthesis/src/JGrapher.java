// Monday Sep 7, 2012


import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.lang.Math;
import java.util.Vector;
import java.util.*;

public class JGrapher extends Applet {

    TextArea input;
    TextArea message;
    DrawPanel dp;
    Scrollbar horBar, verBar;
    Plot[] plots=null; // defined in execute()

    public void init() {
    input  = new TextArea(10,10);
    input.setFont(new Font("Courier",Font.BOLD,12)); 
    
    message  = new TextArea(3,10);
    message.setFont(new Font("Courier",Font.PLAIN,12));
    message.setEditable(false);
    
    horBar = new Scrollbar(Scrollbar.HORIZONTAL);
    horBar.setVisible(true);
    horBar.addAdjustmentListener(new AdjustmentListener(){
    	public void adjustmentValueChanged(AdjustmentEvent e){
    		if(dp.plots!=null) dp.repaint();
    		}
    	});
    verBar = new Scrollbar(Scrollbar.VERTICAL);
    verBar.setVisible(true);
    verBar.addAdjustmentListener(new AdjustmentListener(){
    	public void adjustmentValueChanged(AdjustmentEvent e){
    		if(dp.plots!=null) dp.repaint();   		
    		}
    	});   
    
    
    ScrollPane drawPane = new ScrollPane(ScrollPane.SCROLLBARS_NEVER);
    drawPane.setSize(300,400);
    dp = new DrawPanel(drawPane ,horBar,verBar);
    drawPane.add(dp);
    
    
    Choice choice = new Choice();
    choice.addItem("circle");
    choice.addItem("ellipse");
    choice.addItem("hyperbola");
    choice.addItem("tangent line");
    choice.addItem("exp and log");
    choice.addItem("y=1/x");
    choice.addItem("rotated ellipse");
    choice.addItem("colors");
    choice.addItemListener(new ItemListener(){
    	public void itemStateChanged(ItemEvent e){
    		example((String)e.getItem());
    	}
    });
    Panel choicePanel = new Panel();
    choicePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
    choicePanel.add(new Label("Select a predefined program "));//
    choicePanel.add(choice);
    choicePanel.add(new Label(" OR "));
    
    Button xButton = new Button("Execute");
    xButton.addActionListener(new ActionListener(){
    	public void actionPerformed(ActionEvent e){execute();}
    	});
    Panel xPanel = new Panel();
    xPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
    xPanel.add(new Label("and press the"));// 
    xPanel.add(xButton);
    xPanel.add(new Label("button."));//.
    
    
    CheckboxGroup checkboxGroup= new CheckboxGroup();
    Checkbox rescaleToFit= new Checkbox("Rescale axes to fit", checkboxGroup,false);//
    Checkbox scaleAxesEqually= new Checkbox("Scale axes equally", checkboxGroup,true);//
    rescaleToFit.addItemListener( new ItemListener(){
    	public void itemStateChanged(ItemEvent e){
    		dp.rescale=true; if(dp.plots!=null) dp.setPlots(plots);
        }
    });
    scaleAxesEqually.addItemListener( new ItemListener(){
    	public void itemStateChanged(ItemEvent e){
    		dp.rescale=false; if(dp.plots!=null) dp.setPlots(plots);
        }
    });
    
   
    Button cButton = new Button("Clear");
    cButton.addActionListener(new ActionListener(){
    	public void actionPerformed(ActionEvent e){clear();}
    	});
    
    
    //controlPanel.setLayout(new GridBagLayout());
    GridBagConstraints c = new GridBagConstraints();
    c.fill=GridBagConstraints.BOTH;
    c.gridx=0; c.gridwidth=1; c.gridheight=1;
    
    Panel outerPanel = new Panel();
    outerPanel.setLayout(new GridBagLayout());
    c.gridwidth=4; c.gridheight=4;c.gridx=0; c.gridy=0; 
    outerPanel.add(drawPane,c);
    c.gridwidth=1; c.gridheight=4;c.gridx=4; c.gridy=0; 
    outerPanel.add(verBar,c);
    c.gridwidth=4; c.gridheight=1;c.gridx=0; c.gridy=4; 
    outerPanel.add(horBar,c);	
    
    setLayout(new GridBagLayout());
    c.gridwidth=3; c.gridx=0; 
    c.gridheight=1;c.gridy=0; add(choicePanel,c);
    c.gridheight=1;c.gridy=1; add(new Label("Input graphing commands here"),c);//
    c.gridheight=4;c.gridy=2; add(input,c);
    c.gridheight=1;c.gridy=6; add(xPanel,c);
    c.gridheight=1;c.gridy=7; add(new Label("Error messages appear here"),c);//
    c.gridheight=2;c.gridy=8; add(message,c);
    c.gridheight=1;c.gridy=10;add(rescaleToFit,c);
    c.gridheight=1;c.gridy=11;add(scaleAxesEqually,c);
    c.gridheight=1;c.gridy=12; c.gridwidth=1; add(cButton,c);
    c.gridwidth=4; c.gridx=4; 
    c.gridheight=13;c.gridy=0; add(outerPanel,c);
    }
    
	void  execute(){
		try{
	         String text=input.getText();
	         Jplot jplot=new Jplot(text,this);
			 plots = jplot.execute();
	         dp.setPlots(plots);
        }catch (Exception ex){
	         message.setText(ex.getMessage());
	    }
	 }
	 
	 void  clear(){
		try{
	         input.setText("");
	         message.setText("");
	         Jplot jplot=new Jplot("",this);
          	 plots = jplot.execute();
	         dp.setPlots(plots);
        }catch (Exception ex){
	         message.setText(ex.getMessage());
	    }
	 }
	     
	     
	 void example(String item){
	 	String prog="";
	 	if(item.equals("circle")){
	 		prog = "# graph of circle x^2+y^2=1\n\n" +
	 		       "plot cos(t), sin(t) for 0<t<2*pi\n\n"+
	 		       "% draw axes\n"+
				   "plot x,0 for -4<x<4\n"+
                   "plot 0,y for -7<y<7\n"; 
	 	}else
	 	if(item.equals("ellipse")){
	 		prog = "% graph of ellipse x^2/49 + y^2/9 = 1\n\n"+
	 		       "plot 7*cos(t), 3*sin(t) for 0<t<2*pi\n"+
				   "plot x,0 for -10<x<10\n"+
                   "plot 0,y for -10<y<10\n"; 
	 	}else
	 	if(item.equals("hyperbola")){
	 		prog = "# graph of hyperbola x^2-y^2=1\n\n"+
	 		       "cosh(t)=(exp(t)+exp(-t))/2\n"+ 
				   "sinh(t)=(exp(t)-exp(-t))/2\n\n"+ 
				   "plot cosh(t), sinh(t) for -2<t<2\n"+ 
				   "plot -cosh(t), sinh(t) for -2<t<2\n\n"+ 
				   "plot x,0 for -cosh(2)<x<cosh(2)\n"+ 
				   "plot 0,y for -cosh(2)<y<cosh(2)\n";
	 	}else
	 	if(item.equals("tangent line")){
	 		prog = "f(x)=sin(x)          # graph y=f(x) and the\n"+
	 		       "a=1                  # tangent line at (a,f(a))\n"+
	 		       "f'(x)=cos(x)\n\n"+
	 		       "L(x)=f(a)+f'(a)*(x-a) #linear approximation\n"+
	 		       "plot x,f(x) for -2*pi<x<2*pi\n"+
	 		       "plot x,L(x) for -4<x<4\n\n"+
				   "plot x,0 for -6<x<6   # x axis\n"+
                   "plot 0,y for -7<y<7   # y axis\n"; 
	 	}else
	 	if(item.equals("exp and log")){
	 		prog = "# the graphs y=exp(x) and x=log(y) coincide.\n"+
	 		       "# I shifted y=exp(x) up so you can see it.\n\n"+
	 		       "color(red)\n"+
	 		       "plot x,exp(x)+0.05 for -1<x<1\n\n"+
	 		       "color(blue)\n"+
	 		       "plot log(y), y for exp(-1)<y<exp(1)\n";
	 	}else
	 	if(item.equals("y=1/x")){
	 		prog = "# y=1/x becomes infinite at x=0\n"+
	 		       "# avoid potting near x=0\n"+
	 		       "# so graph looks nice\n\n"+
	 		       "plot x,1/x for -4<x<-0.1 \n"+
	 		       "plot x,1/x for 0.1<x<4  \n"+
	 		       "color(yellow)\n"+
				   "plot x,0 for -4<x<4\n"+
                   "plot 0,y for -9<y<9\n"; 
	 	}else
		if(item.equals("rotated ellipse")){
			prog =	"# y^2+xy+2x^2-1=0\n"+
					"A(x)=1\n"+
					"B(x)=x\n"+
					"C(x)=2*x^2-1\n"+
					"f(x)=(-B(x)+sqrt(B(x)^2-4*A(x)*C(x)))/(2*A(x))\n"+
					"g(x)=(-B(x)-sqrt(B(x)^2-4*A(x)*C(x)))/(2*A(x))\n"+
					"color(blue)\n"+
					"plot x,f(x) for -1<x<1\n"+
					"color(red)\n"+
					"plot x,g(x) for -1<x<1\n"+
					"# B(x)^2-4*A(x)*C(x)=0 when x=+/- sqrt(4/7)\n"+
					"color(black)\n"+
					"plot  sqrt(4/7), y for -2<y<2\n"+
					"plot -sqrt(4/7), y for -2<y<2\n"+
					"color(pink)\n"+
					"plot          0, y for -2<y<2\n"+
					"plot          x, 0 for -2<x<2\n";
		}else
	 	if(item.equals("colors")){
	 		prog = "color(black) plot x,1 for 0<x<13"+
	 		       " color(0,0,0) plot 1,y for 0<y<13\n"+
	 		       "color(blue) plot x,2 for 0<x<13"+
	 		       " color(0,0,255) plot 2,y for 0<y<13\n"+
	 		       "color(cyan) plot x,3 for 0<x<13"+
	 		       " color(0,255,255) plot 3,y for 0<y<13\n"+
	 		       "color(darkGray) plot x,4 for 0<x<13"+
	 		       " color(64,64,64) plot 4,y for 0<y<13\n"+
	 		       "color(gray) plot x,5 for 0<x<13"+
	 		       " color(128,128,128) plot 5,y for 0<y<13\n"+
	 		       "color(green) plot x,6 for 0<x<13"+
	 		       " color(0,255,0) plot 6,y for 0<y<13\n"+
	 		       "color(lightGray) plot x,7 for 0<x<13"+
	 		       " color(192,192,192) plot 7,y for 0<y<13\n"+
	 		       "color(magenta) plot x,8 for 0<x<13"+
	 		       " color(255,0,255) plot 8,y for 0<y<13\n"+
	 		       "color(orange) plot x,9 for 0<x<13"+
	 		       " color(255,200,0) plot 9,y for 0<y<13\n"+
	 		       "color(pink) plot x,10 for 0<x<13"+
	 		       " color(255,175,175) plot 10,y for 0<y<13\n"+
	 		       "color(red) plot x,11 for 0<x<13"+
	 		       " color(255,0,0) plot 11,y for 0<y<13\n"+
	 		       "color(yellow) plot x,12 for 0<x<13"+
	 		       " color(255,255,0) plot 12,y for 0<y<13\n"+
	 		       "color(64,128,192) plot x,x for 0<x<13\n";
	 	}
	 	input.setText(prog);
	 	execute();
	 }
	 

	 void dump(){
	 	try{
            //Transcript transcript=new Transcript("for debugging");
	 		String text=input.getText();
	        System.out.println("********\n"+text);
	        Jplot jplot=new Jplot(text,this);
			System.out.println("\n rescale = "+dp.rescale+"\n"+jplot.dumpProgram());
	        }catch (Exception ex){
	            message.setText(ex.getMessage());
	        }
	 }    




			
//inner class		
class DrawPanel extends Panel{
	ScrollPane parent;
	boolean rescale=false;
	Scrollbar horBar;
	Scrollbar verBar;
	//following are defined in setPlots()
	Plot[] plots=null;  
    double Xmin, Ymin, Xmax, Ymax; // max and min over all the plots
	int visibleHeight; //  = parent.height
	int visibleWidth;  //  = parent.width 
    int height; // height/width = visibleHeight/visibleWidth if rescale
    int width;  //              = (Ymax-Ymin)/(Xmax-Xmin)  if not
	
	
	
	DrawPanel(ScrollPane parent,Scrollbar horBar, Scrollbar verBar){
		this.parent = parent;
		this.horBar = horBar;
		this.verBar = verBar;
		visibleHeight = parent.getHeight();
		visibleWidth = parent.getWidth();
	}
	
	void setPlots(Plot[] plots){
		this.plots=plots;
        // calculate rectangle which contains all the plots
        Xmin=Double.POSITIVE_INFINITY;
        for(int i=0;i<plots.length; i++) if(plots[i].Xmin<Xmin) Xmin=plots[i].Xmin;
        Ymin=Double.POSITIVE_INFINITY;
        for(int i=0;i<plots.length; i++) if(plots[i].Ymin<Ymin) Ymin=plots[i].Ymin;
        Xmax=Double.NEGATIVE_INFINITY;
        for(int i=0;i<plots.length; i++) if(plots[i].Xmax>Xmax) Xmax=plots[i].Xmax;
        Ymax=Double.NEGATIVE_INFINITY;
        for(int i=0;i<plots.length; i++) if(plots[i].Ymax>Ymax) Ymax=plots[i].Ymax;
        
        double Width  = Xmax-Xmin;
        double Height = Ymax-Ymin;
        
        //make sure nothing stupid happens
        if(Width==0 && Height==0){Width=1; Height=1;}
        else if(Width==0){Width=Height;}
        else if(Height==0){Height=Width;}
        
        // add a little border
        Xmax+=0.05*Width;  Xmin-=0.05*Width;
        Ymax+=0.05*Height; Ymin-=0.05*Height;  
        
        // calculate height, width  
		visibleHeight = parent.getHeight();
		visibleWidth = parent.getWidth();
        setSize(visibleWidth,visibleHeight); 
        height = visibleHeight;
        width  = visibleWidth;
        verBar.setVisible(false);
        horBar.setVisible(false);
        horBar.setValues(visibleWidth, visibleWidth, 0, visibleWidth); 
        verBar.setValues(visibleHeight, visibleHeight , 0, visibleHeight); 
        if(!rescale){
            if((Xmax-Xmin)*visibleHeight>(Ymax-Ymin)*visibleWidth){ 
               //scroll horizontally
               horBar.setVisible(true); 
               width = (int)(((Xmax-Xmin)/(Ymax-Ymin))*height);
               horBar.setValues(0, visibleWidth, 0, width); 
               horBar.setValue((width-visibleWidth)/2); 
               horBar.setUnitIncrement(visibleWidth/5);
               horBar.setBlockIncrement(visibleWidth/2);
            }else{ 
               //scroll vertically
               verBar.setVisible(true); 
               height = (int)(((Ymax-Ymin)/(Xmax-Xmin))*width);
               verBar.setValues(0, visibleHeight, 0, height);
               verBar.setValue((height-visibleHeight)/2); 
               verBar.setUnitIncrement(visibleHeight/5);
               verBar.setBlockIncrement(visibleHeight/2);
            }
        }	
        repaint();	     
	}
	
	public void paint(Graphics g){
		if(plots==null) return;
		int tx=0; // used for shifting the viewrectangle
		int ty=0;
		if(!rescale && horBar.isVisible()) tx=horBar.getValue();
		if(!rescale && verBar.isVisible()) ty=verBar.getValue();
	
        for(int i=0; i<plots.length;i++)if(plots[i].length()>0){
        	g.setColor(plots[i].color);
        	int x=(int)(((plots[i].X[0]-Xmin)/(Xmax-Xmin))*width);
        	int y=(int)(((plots[i].Y[0]-Ymin)/(Ymax-Ymin))*height);
        	for(int j=1;j<plots[i].length();j++){
           	    int last_x=x;
           		int last_y=y;
           		x=(int)(((plots[i].X[j]-Xmin)/(Xmax-Xmin))*width);
           		y=(int)(((plots[i].Y[j]-Ymin)/(Ymax-Ymin))*height);
	            //ty=0 when bubble is highest, ty = height-visibleWidth at lowest
           		g.drawLine(last_x-tx,height-last_y-ty,x-tx,height-y-ty);
            }
        }
	}
} //DrawPanel
} //JGrapher 


/******************* Syntax Diagrams ***********************

Statement::
   MacroDefinition
 | PlotStatement
 | ColorStatement
 
MacroDefinition::
   ConstantDefinition
 | FunctionDefinition

ConstantDefinition::
  [DEFINE] ConstantName = ExpressionC

FunctionDefinition::
  [DEFINE] FunctionName(IdentifierF [[IdentifierF]]) = ExpressionF

PlotStatement::
PLOT  ExpressionP, ExpressionP FOR ExpressionC < IdentifierP < ExpressionC

Expression_3::
    [+] Expression_2 [+ Expression_2]]

Expression_2::
    Expression_1 [[* Expression_1]]

Expression_1::
    Expression_0 [^ Expression_0]

Expression_0::
    Number
  | (Expression_3)
  | ConstantName
  | FunctionName(Expression_3 [[Expression_3]])
  | SIN(Expression_3)
  | Identifier

Atom:: IdentifierF | IdentifierP

ColorStatement::
     COLOR(color)
   | COLOR(Number,Number,Number)

---------------------------------

  After macro expansion  ExpressionC is an Expression_3 containing
  no Identifier,   ExpressionF is an Expression_3 containing only
  the IdentifierFs in the declaration, and ExpressionP is an
  Expression_3 containing only the IdentifierP after the FOR.
  color is one of the strings in colorList of class ColorStatement
  below (case insensitive)

************************************************************/

class Jplot{
    Vector program;// of statements
    Tokenizer tkns;
    Color  currentColor;

    Jplot(String text,JGrapher fe) throws Syntax{ //fe: front_end
        program = new Vector();
        currentColor=Color.black; //reset during compile
	    tkns = new Tokenizer(text);
	    tkns.nextToken();
	    while(tkns.hasMoreTokens()){
	        switch(tkns.theToken.type){
	            case Token.PLOT:
	                PlotStatement ps =new PlotStatement(this);
	                program.addElement(ps);
					// System.out.println(ps.dump());
	                break;
	            case Token.COLOR: 
	                ColorStatement cs =new ColorStatement(this);
	                if(cs.color!=null) currentColor=cs.color;
					// System.out.println(ps.dump());
	                break;
	            case Token.DEFINE: tkns.nextToken();
	                break;
	            case Token.IDENTIFIER:
	                Macro mac=new Macro(this);
	                program.addElement(mac);
					//System.out.println(mac.dump()); 
	                break;
	            default: throw new Syntax("A statement cannot begin with this symbol: "+tkns.theToken.name);
	        }
	    }
    }

    Macro lookup(String name){
        for(int i=0;i<program.size(); i++)
            if(program.elementAt(i)instanceof Macro)
            if(name.equals(((Macro)program.elementAt(i)).name))
                return ((Macro)program.elementAt(i));
        return null;
    }

    Plot[] execute(){
        int count = 0;
        for(int i=0;i<program.size(); i++)
            if(program.elementAt(i)instanceof PlotStatement)
                count++;
        Plot[] plots=new Plot[count];
        count = 0;
        for(int i=0;i<program.size(); i++)
            if(program.elementAt(i)instanceof PlotStatement){
                PlotStatement plot=(PlotStatement) program.elementAt(i); 
                plots[count]=plot.execute(200);// 200 points in this plot
                count++;
        	}
        return plots;
    }

    String dumpProgram(){
        String str="";
        for(int i=0; i<program.size();i++){
            if(program.elementAt(i)instanceof PlotStatement)
            str+= "\n"+((PlotStatement)program.elementAt(i)).dump();
            else
            if(program.elementAt(i)instanceof Macro)
            str+= "\n"+((Macro)program.elementAt(i)).dump();
            else
            if(program.elementAt(i)instanceof ColorStatement)
            str+= "\n"+((ColorStatement)program.elementAt(i)).dump();
        }
        return str;
    }

    String dumpPlots(){
        String str="";
        Plot[] plots= execute();
        for(int i=0;i<plots.length;i++){
            Plot plot = plots[i];
            str+=(plot.color).toString();
            str+="\n------------\n";
            str+="Xmin = "+Double.toString(plot.Xmin)+"\n";
            str+="Ymin = "+Double.toString(plot.Ymin)+"\n";
            str+="Xmax = "+Double.toString(plot.Xmax)+"\n";
            str+="Ymax = "+Double.toString(plot.Ymax)+"\n";
            for(int j=0;j<plot.length();j++)
            str+="("+Double.toString(plot.X[j])+","+
                     Double.toString(plot.Y[j])+")\n";
        }
        return str;
    }
}// class Jplot



class Token{

    static final int ILLEGAL=-1;
    static final int IDENTIFIER = 0;
    static final int NUMBER = 1;
    static final int EQUALS = 2;
    static final int BINARY = 3;
    static final int RELATION = 4;
    static final int DEFINE = 5;
    static final int PLOT = 6;
    static final int FOR = 7;
    static final int LPAREN = 8;
    static final int RPAREN = 9;
    static final int COMMA = 10;
    static final int COLOR = 11;
    static final int EOF = 12;

    int type;
    String name;
    int index; // for locating token in text



    Token(String str, int x){
        name  = str;
        index = x;
        if(Tokenizer.isDigit(name.charAt(0)))   type=NUMBER; else
        if(Tokenizer.isAlpha(name.charAt(0))){
            if(name.equalsIgnoreCase("plot"))   type=PLOT;else
            if(name.equalsIgnoreCase("for"))    type=FOR; else
            if(name.equalsIgnoreCase("define")) type=DEFINE;else
            if(name.equalsIgnoreCase("color"))  type=COLOR;else
                 type=IDENTIFIER;
        }else
        if(name.equals("=")) type=EQUALS; else
        if(name.equals("+")) type=BINARY; else
        if(name.equals("-")) type=BINARY; else
        if(name.equals("*")) type=BINARY; else
        if(name.equals("/")) type=BINARY; else
        if(name.equals("^")) type=BINARY; else
        if(name.equals("<")) type=RELATION; else
        if(name.equals("<="))type=RELATION; else
        if(name.equals("(")) type=LPAREN; else
        if(name.equals(")")) type=RPAREN; else
        if(name.equals(",")) type=COMMA; else
                             type=ILLEGAL;
    }

    static String nameOf(int type){
        switch(type){
        	case ILLEGAL: return "illegal";
            case IDENTIFIER: return "Identifier ";
            case NUMBER: return "Number ";
            case EQUALS: return "'=' ";
            case BINARY: return "'+' ";
            case RELATION: return "'<' ";
            case DEFINE: return "define ";
            case PLOT:  return "plot ";
            case FOR:  return "for ";
            case LPAREN: return "'(' ";
            case RPAREN: return "')' ";
            case COMMA: return  "','";
            case COLOR: return "color ";
            case EOF: return  "eof ";
            default: throw new IllegalArgumentException("BOMB: Illegal type");
        }
    }

}


class Tokenizer{

	String text;
	int index;
	int len;

	Token theToken;

	public Tokenizer(String text){
    	this.text = text;
    	len = text.length();
    	index = 0;
	}


	public boolean hasMoreTokens(){
    	skipWhiteSpace();
    	return index<len;
	}

	public Token nextToken()throws  Syntax{
    	if(hasMoreTokens()){
        	int sx = index;
        	if(isAlpha(text.charAt(index))){
            	while(index<len && isAlphaNum(text.charAt(index))) index++;
        	} else
        	if(isDigit(text.charAt(index))||text.charAt(index)=='.'){
            	while(index<len && isDigit(text.charAt(index))) index++;
            	if(index<len && text.charAt(index)=='.') index++;
            	while(index<len && isDigit(text.charAt(index))) index++;
        	}else
        	if(index<len && text.charAt(index)=='<'){
            	index++;
            	if(index<len && text.charAt(index)=='=')index++;
        	}else
        	if(index<len && text.charAt(index)=='*'){
            	index++;
            	if(index<len && text.charAt(index)=='*')index++;
        	}else
            	index++;
        	String str = text.substring(sx,index);
        	if(str.length()>1 && str.charAt(0)=='.') str="0"+str;
        	theToken = new Token(str,index);
        	return  theToken;
    	}
    	else{
        	Token tk=new Token("End of File",index);
        	tk.type=Token.EOF;
        	return tk;
    	}
	}

	void skipWhiteSpace(){
    	while(index<len && isWhiteSpace(text.charAt(index))){
        	if(index<len && isComment(text.charAt(index))){
            	while(index<len &&text.charAt(index)!='\n') index++;
            	index++;
        	}else
            	index++;
    	}
	}

	static boolean isDigit(char ch){
    	return '0'<=ch && ch<='9';
	}
	static boolean isAlpha(char ch){
    	return 'a'<=ch && ch <= 'z' ||'A'<=ch && ch <= 'Z' || ch=='_' ;
	}

	static boolean isAlphaNum(char ch){
    	return isDigit(ch)|| isAlpha(ch)|| ch=='\'';
	}
	static boolean isWhiteSpace(char ch){
    	return ch==' ' || ch=='\n'||  isComment(ch);
	}
	static boolean isComment(char ch){
    	return ch=='%' || ch == '#';
	}

	void mustBe(int type) throws  Syntax{
    	if(theToken.type!=type)
        	throw new  Syntax(Token.nameOf(type)+" expected not "+theToken.name);
    	else
        	nextToken();
	}
}// Tokenizer

class Atom{

     String name;
     double value;

    Atom(String name, double value){
        this.name=name;
        this.value=value;
    }

    Atom(String name){
        this(name,Double.NaN);
    }
}

class Operation{

    static final int UNKNOWN=-1;
    static final int ABS=0;
    static final int ACOS=1;
    static final int ASIN=2;
    static final int ATAN=3;
    static final int CEIL=4;
    static final int COS=5;
    static final int EXP=6;
    static final int FLOOR=7;
    static final int LOG=8;
    static final int SIN=9;
    static final int SQRT=10;
    static final int TAN=11;
    static final int MAX=12;
    static final int MIN=13;
    static final int POW=14;
    static final int PLUS=15;
    static final int MINUS=16;
    static final int TIMES=17;
    static final int DIV=18;
    static final int E=19;
    static final int PI=20;

    String name;
    int opcode;
    int index;

    Operation(Token tk){
        name=tk.name;
        opcode = identify(name);
        index=tk.index;
    }


    static int identify(String func){
        if(func.equals("+"))               return PLUS; else
        if(func.equals("-"))               return MINUS; else
        if(func.equals("*"))               return TIMES; else
        if(func.equals("/"))               return DIV; else
        if(func.equals("^"))               return POW; else
        if(func.equals("**"))              return POW; else
        if(func.equalsIgnoreCase("abs"))   return ABS; else
        if(func.equalsIgnoreCase("acos"))  return ACOS;else
        if(func.equalsIgnoreCase("asin"))  return ASIN;else
        if(func.equalsIgnoreCase("atan"))  return ATAN;else
        if(func.equalsIgnoreCase("ceil"))  return CEIL;else
        if(func.equalsIgnoreCase("cos"))   return COS;else
        if(func.equalsIgnoreCase("exp"))   return EXP;else
        if(func.equalsIgnoreCase("floor")) return FLOOR;else
        if(func.equalsIgnoreCase("log"))   return LOG;else
        if(func.equalsIgnoreCase("sin"))   return SIN;else
        if(func.equalsIgnoreCase("sqrt"))  return SQRT;else
        if(func.equalsIgnoreCase("tan"))   return TAN;else
        if(func.equalsIgnoreCase("max"))   return MAX;else
        if(func.equalsIgnoreCase("min"))   return MIN;else
        if(func.equalsIgnoreCase("pow"))   return POW;else
        if(func.equalsIgnoreCase("e"))     return E;else
        if(func.equalsIgnoreCase("pi"))    return PI;else
        return UNKNOWN;
    }

    double evaluate(){
        switch(opcode){
        case E:  return Math.E;
        case PI: return Math.PI;
        default: throw new IllegalArgumentException("BOMB: Unknown constant");
        }
    }

    double evaluate(double arg){
        switch(opcode){
        case ABS:   return Math.abs(arg);
        case ACOS:  return Math.acos(arg);
        case ASIN:  return Math.asin(arg);
        case ATAN:  return Math.atan(arg);
        case CEIL:  return Math.ceil(arg);
        case COS:   return Math.cos(arg);
        case EXP:   return Math.exp(arg);
        case FLOOR: return Math.floor(arg);
        case LOG:   return Math.log(arg);
        case SIN:   return Math.sin(arg);
        case SQRT:  return Math.sqrt(arg);
        case TAN:   return Math.tan(arg);
        case MINUS: return -arg;
        default:    throw new IllegalArgumentException("BOMB: Unknown unary operation");
        }
    }

    double evaluate(double arg1, double arg2){
        switch(opcode){
        case MAX:   return Math.max(arg1,arg2);
        case MIN:   return Math.min(arg1,arg2);
        case POW:   return Math.pow(arg1,arg2); 
        case PLUS:  return arg1+arg2;
        case MINUS: return arg1-arg2;
        case TIMES: return arg1*arg2;
        case DIV:   return arg1/arg2;
        default:    throw new IllegalArgumentException("BOMB: Unknown binary operation");
        }
    }

    static int arity(int op){
        switch(op){
        case UNKNOWN: return -1;
        case ABS:     return 1;
        case ACOS:    return 1;
        case ASIN:    return 1;
        case ATAN:    return 1;
        case CEIL:    return 1;
        case COS:     return 1;
        case EXP:     return 1;
        case FLOOR:   return 1;
        case LOG:     return 1;
        case SIN:     return 1;
        case SQRT:    return 1;
        case TAN:     return 1;
        case MAX:     return 2;
        case MIN:     return 2;
        case POW:     return 2;
        case PLUS:    return 2;
        case MINUS:   return 2;
        case TIMES:   return 2;
        case DIV:     return 2;
        case E:       return 0;
        case PI:      return 0;
    default: throw new IllegalArgumentException("BOMB: Unrecognized opcode");
        }
    }
}

class Expression extends Vector{

    Tokenizer tkns;
    Jplot prgm;
    Double zero = new Double(0.0);


    Expression(Jplot prgm)throws Syntax{
        this.tkns=prgm.tkns;
        this.prgm=prgm;
        expression_3();
    }

    void expression_3() throws Syntax{
	if(tkns.theToken.name.equals("+")){//unary plus
		tkns.nextToken();
		expression_2();
        }else if(tkns.theToken.name.equals("-")){//unary minus
		addElement(zero);
		Token tk1 = tkns.theToken;
		tkns.nextToken();
		expression_2();
		addElement(new Operation(tk1));
        }else{
		expression_2();
        }
        while(tkns.theToken.name.equals("+")||tkns.theToken.name.equals("-")){
		Token tk = tkns.theToken;
		tkns.nextToken();
		expression_2();
		addElement(new Operation(tk));
    	}//while
    }//expression_3

    void expression_2()throws Syntax{
        expression_1();
        while(tkns.theToken.name.equals("*")||tkns.theToken.name.equals("/")){
            Token tk = tkns.theToken;
            tkns.nextToken();
            expression_1();
            addElement(new Operation(tk));
        }
    }

    void expression_1()throws Syntax{
        expression_0();
        if(tkns.theToken.name.equals("^")||tkns.theToken.name.equals("**")){
            Token tk = tkns.theToken;
            tkns.nextToken();
            expression_0();
            addElement(new Operation(tk));
        }
    }

    void expression_0()throws Syntax{
        if(tkns.theToken.type==Token.NUMBER){
            addElement(new Double(tkns.theToken.name));
            tkns.nextToken();
        }else
        if(tkns.theToken.type==Token.LPAREN){
            tkns.nextToken();
            expression_3();
            tkns.mustBe(Token.RPAREN);
        }else
        if(tkns.theToken.type==Token.IDENTIFIER){
            Macro func = prgm.lookup(tkns.theToken.name);
            int op = Operation.identify(tkns.theToken.name);
            if(func!=null){
                func.expand(this);
            }else
            if(op!=Operation.UNKNOWN){
                Operation operation = new Operation(tkns.theToken);
                tkns.nextToken();
                switch(Operation.arity(op)){
                    case 2: tkns.mustBe(Token.LPAREN);
                            expression_3();
                            tkns.mustBe(Token.COMMA);
                            expression_3();
                            tkns.mustBe(Token.RPAREN);
                            break;
                    case 1: tkns.mustBe(Token.LPAREN);
                            expression_3();
                            tkns.mustBe(Token.RPAREN);
                            break;
                    case 0: break;
                    default: throw new Syntax("Too many arguments for " + operation.name);
                    }//switch
                    addElement(operation);
            }else{
                addElement(new Atom(tkns.theToken.name,Double.NaN));
                tkns.nextToken();
            }
        }else
        throw new Syntax("An expression should not begin with "+tkns.theToken.name);
    }



    double execute(double t){
        int len = size();
        double[] stack = new double[len];
        int top = 0;
        for(int i=0; i<len; i++){
            if(elementAt(i) instanceof Double)
                stack[top++]=((Double)elementAt(i)).doubleValue();
            else
            if(elementAt(i) instanceof Atom)
                stack[top++]=t;
            else
            if(elementAt(i) instanceof Operation){
                Operation op = (Operation)elementAt(i);
                int arity = Operation.arity(op.opcode);
                if(top<arity) throw new IllegalArgumentException("BOMB: Stack underflow");
                else switch(arity){
                    case 0: stack[top++]=op.evaluate();
                            break;
                    case 1: double c=stack[--top];
                            stack[top++]=op.evaluate(c);
                            break;
                    case 2: double b=stack[--top];
                            double a=stack[--top];
                            stack[top++]=op.evaluate(a,b);
                            break;
                    default:throw new IllegalArgumentException("BOMB: arity>2?");
                }
            }else
                throw new IllegalArgumentException("BOMB: Illegal expression element: "+elementAt(i).toString());
        }
        if(top!=1)
            throw new IllegalArgumentException("BOMB: Bad evaluation stack");
        else
            return stack[0];

    }

    String dump(){
        String str="";
        for(int i=0;i<size();i++){
            if(elementAt(i) instanceof Atom)
                str+=((Atom)elementAt(i)).name+" ";
            else
            if(elementAt(i) instanceof Operation)
                str+=((Operation)elementAt(i)).name+" ";
            else
            if(elementAt(i) instanceof Double)
                str+=((Double)elementAt(i)).toString()+" ";
            else
                str+=elementAt(i).toString();
        }
        return str;
    }
}

class Macro{
    Expression expression;
    Vector parameters; // of Strings
    String name;
    Tokenizer tkns;
    Jplot prgm;


    Macro(Jplot prgm)throws Syntax{
        this.prgm=prgm;
        this.tkns=prgm.tkns;
        if(tkns.theToken.type!=Token.IDENTIFIER)
        throw new IllegalArgumentException("BOMB: IDENTIFIER missing");
        name = tkns.theToken.name;
        prgm.program.addElement(this);
        parameters = new Vector();
        tkns.nextToken();
        if(tkns.theToken.type==Token.LPAREN){
            tkns.nextToken();
            while(tkns.theToken.type==Token.IDENTIFIER){
                parameters.addElement(tkns.theToken.name);
                tkns.nextToken();
                if(tkns.theToken.type==Token.COMMA)tkns.nextToken();
            }
            tkns.mustBe(Token.RPAREN);
        }
        tkns.mustBe(Token.EQUALS);
        expression = new Expression(prgm);
        check();
    }

    void check()throws Syntax{
        if(expression.size()>0){
            for(int i=0;i<expression.size();i++)
            if(expression.elementAt(i)instanceof Atom){
                String name = ((Atom)expression.elementAt(i)).name;
                if(parameters.indexOf(name)<0)
                  throw new Syntax("Unrecognized identifier: "+name);
            }
        }else
        throw new IllegalArgumentException("BOMB: Missing expression");
    }

    void expand(Expression expr)throws Syntax{
        Hashtable values = new Hashtable(); // of Expressions
        if(!tkns.theToken.name.equals(name))
            throw new IllegalArgumentException("BOMB: Parser out of phase");
        tkns.nextToken();
        if(tkns.theToken.type==Token.LPAREN){
            tkns.nextToken();
            for(int i=0;i<parameters.size(); i++){
                values.put(parameters.elementAt(i), new Expression(prgm));
                if(tkns.theToken.type==Token.COMMA)tkns.nextToken();
            }
            tkns.mustBe(Token.RPAREN);
        }
        for(int i=0; i<expression.size(); i++){
            if(expression.elementAt(i) instanceof Atom){
                Expression ex=(Expression)values.get(((Atom)expression.elementAt(i)).name);
                for(int j=0;j<ex.size();j++)
                    expr.addElement(ex.elementAt(j));
            }else
                expr.addElement(expression.elementAt(i));
        }
    }

    String dump(){
        String str="\n parameters: ";
        for(int i=0;i<parameters.size();i++)
            str+= (String)parameters.elementAt(i)+" ";
        return "\n MACRO "+name+" "+expression.dump()+str;

    }
}

class PlotStatement{
  Expression  abscissa, ordinate, lowerLimit, upperLimit;
  Atom parameter=null;
  Tokenizer tkns;
  Color color;
  
  PlotStatement(Jplot prgm)throws Syntax{
    this.tkns=prgm.tkns;
    color=prgm.currentColor;
    if(tkns.theToken.type!=Token.PLOT)
        throw new IllegalArgumentException("BOMB: PLOT missing");
    else
        tkns.nextToken();
    abscissa = new Expression(prgm);
    if(tkns.theToken.type==Token.COMMA)tkns.nextToken();
    ordinate = new Expression(prgm);
    tkns.mustBe(Token.FOR);
    lowerLimit = new Expression(prgm);
    tkns.mustBe(Token.RELATION);
    if(tkns.theToken.type==Token.IDENTIFIER){
        parameter = new Atom(tkns.theToken.name);
        tkns.nextToken();
    }else
        throw new Syntax("Plot parameter expected, not "+tkns.theToken.name);
    tkns.mustBe(Token.RELATION);
    upperLimit = new Expression(prgm);
    check(1,abscissa);
    check(1,ordinate);
    check(0,lowerLimit);
    check(0,upperLimit);
  }

  void check(int tag, Expression expression)throws Syntax{
    if(parameter==null)
        throw new IllegalArgumentException("BOMB: Missing plot parameter");
    if(expression.size()>0){
        for(int i=0;i<expression.size();i++)
        if(expression.elementAt(i)instanceof Atom){
            String name = ((Atom)expression.elementAt(i)).name;
            if(tag==0 ||  !name.equals(parameter.name))
                throw new Syntax("Unrecognized identifier: "+name);
        }
    }else throw new Syntax("Expression expected");
  }

  Plot execute(int numberOfPoints){
    Plot plot = new Plot(numberOfPoints,color);
    double a= lowerLimit.execute(Double.NaN);
    double b= upperLimit.execute(Double.NaN);
    double dt = (b-a)/(numberOfPoints-1);
    double t=a;
    for(int i=0; i<numberOfPoints; i++){
        plot.X[i]=abscissa.execute(t);
        plot.Y[i]=ordinate.execute(t);
        if(plot.X[i]<plot.Xmin) plot.Xmin=plot.X[i];
        if(plot.X[i]>plot.Xmax) plot.Xmax=plot.X[i];
        if(plot.Y[i]<plot.Ymin) plot.Ymin=plot.Y[i];
        if(plot.Y[i]>plot.Ymax) plot.Ymax=plot.Y[i];
        t+=dt;
    }
    return plot;
  }

  String dump(){
    return "\n PLOT "+
           "("+abscissa.dump()+" , "+ordinate.dump()+")"+
           "\n FOR "+
            lowerLimit.dump()+" < "+parameter.name+" < "+upperLimit.dump();
  }
}


class Plot{
    double[] X,Y;
    Color color=Color.black;
    private int len;
    double Xmin=Double.POSITIVE_INFINITY; // decreased by PlotStatement.execute()
    double Ymin=Double.POSITIVE_INFINITY; 
    double Xmax=Double.NEGATIVE_INFINITY; // increased by PlotStatement.execute()
    double Ymax=Double.NEGATIVE_INFINITY;
    Plot(int len, Color color){
        this.len=len;
        this.color=color;
        X=new double[len];
        Y=new double[len];
    }
    int length(){
    	return len;
    }
}


class ColorStatement{
	
	Color color;
    Tokenizer tkns;
    
	static Object[][] colorList = {
	    {Color.white,"white"},
	    {Color.black,"black"},
	    {Color.blue,"blue"},
	    {Color.cyan,"cyan"},
	    {Color.darkGray,"darkGray"},
	    {Color.gray,"gray"},
	    {Color.green,"green"},
	    {Color.lightGray,"lightGray"},
	    {Color.magenta,"magenta"},
	    {Color.orange,"orange"},
	    {Color.pink,"pink" },
	    {Color.red,"red"},
	    {Color.yellow,"yellow"}
	    };

    ColorStatement(Jplot prgm)throws Syntax{
    	this.tkns=prgm.tkns;
    	if(tkns.theToken.type!=Token.COLOR)
        	throw new IllegalArgumentException("BOMB: COLOR missing");
        tkns.nextToken();
     	tkns.mustBe(Token.LPAREN);	    	
        if(tkns.theToken.type==Token.IDENTIFIER){
        	color=getColor(tkns.theToken.name);
        	if(color!=null)	tkns.nextToken();
        	else throw new Syntax("Color name (or integer) expected");
        }else
        if(tkns.theToken.type==Token.NUMBER){
			int redValue, greenValue, blueValue;
        	if(tkns.theToken.type==Token.NUMBER)
        		redValue=Integer.parseInt(tkns.theToken.name);
        	else throw new Syntax("Integer expected");
        	tkns.nextToken(); if(tkns.theToken.type==Token.COMMA)tkns.nextToken(); 	
        	if(tkns.theToken.type==Token.NUMBER)
        		greenValue=Integer.parseInt(tkns.theToken.name);
        	else throw new Syntax("Integer expected");
        	tkns.nextToken();if(tkns.theToken.type==Token.COMMA)tkns.nextToken();
        	if(tkns.theToken.type==Token.NUMBER)
        		blueValue=Integer.parseInt(tkns.theToken.name);
        	else throw new Syntax("Integer expected");
    		color = new Color(redValue,greenValue,blueValue);
        	tkns.nextToken();
        }else
        	throw new Syntax("Color name or integer expected");
    	tkns.mustBe(Token.RPAREN);
    }
    
    static Color getColor(String str){
    	for(int i=0; i<colorList.length;i++)
    	if(str.equalsIgnoreCase(((String) colorList[i][1])))
        	return (Color) colorList[i][0];
        return null;
    }
    String dump(){
    		return "\n COLOR( "+color.toString()+")\n";
  	}
}


class Syntax extends Exception{

    Syntax(String msg){
        //super(Jplot.tkns.text.substring(0,Jplot.tkns.index)+"\n"+msg);
        super(msg);
    }
}