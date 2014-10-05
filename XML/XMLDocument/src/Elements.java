import java.util.ArrayList;


public class Elements 
{
	private ArrayList<String> allElements;
	private String stringRep;
	private Tag tag;
	
	
	public Elements(String tagName, Object data)
	{
		this.allElements = new ArrayList<String>();
		
		this.tag = new Tag(tagName);
		
		if (!(data instanceof Elements))
		{
			tag.setData((String)data);
			this.addElement(this.toString());
		}
		
		else
		{
			this.addElement(this.tag.getOpeningTag());
			
			/*
			if (data.getClass().isArray())
			{
				for (int i = 0; i < Array.getLength(data); i++)
				{
					Elements e = (Elements) new Elements( ((Elements) Array.get(data, i)).getTagName(), ((Elements) Array.get(data, i)).getData(Array.get(data, i) ));
					this.addElement(e.toString());
				}
			}
			
			else
			{
		 	    Elements e = new Elements( ((Elements) data).getTagName(), ((Elements) data).getData(data) );
			    this.addElement(e.toString());
			}
			*/
			
			Elements e = new Elements( ((Elements) data).getTagName(), ((Elements) data).getData(data) );
		    this.addElement(e.toString());
			
			this.addElement(this.tag.getClosingTag());
		}
		
	}
	
	
	public ArrayList<String> getElements()
	{
		return this.allElements;
	}
	
	public String getTagName()
	{
		return this.tag.getName();
	}
	
	public Object getData(Object o)
	{
		Elements e = (Elements)o;
		
		String s = e.toString();
		
		String [] sArray = s.split(this.tag.getOpeningTag());
		
		s = new String(sArray[1]);
		
		Object obj = s.substring(0, s.indexOf("<"));
		
		return obj;
	}
	
	
	protected void addElement(String s)
	{
		this.allElements.add(s);
	}
	
	@Override
	public String toString()
	{
		this.stringRep = this.tag.getOpeningTag() + this.tag.getData() + this.tag.getClosingTag();
		
		return this.stringRep;
	}

}
