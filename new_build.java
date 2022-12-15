import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.text.*;



public class Build 
{

	// ************************************** enter fields here *************************************** //
	// ************************************************************************************************ //
	   private static List<Part> parts = new LinkedList<Part>();
	   
	   

	   private static int index;
	   private static int remove_index;
	   private static int remove_check;


	   private static boolean flag;


	   private static Part gp_part; 
	   private static int cat_size = Catalogue.getSize();
	   private static int build_size;
	   private static int temp_size; 
 
	   private static double total_price = 0;
	   private static List <String> temp = new LinkedList<>();
	   private static List <String> complete_set = new LinkedList<>();
	   private static List <String> copy = new LinkedList<>();
	   private static String holderr;
	   //sprivate static Catalogue cata_instance; 

	// ******************************************* end of fields ************************************** //
	// ************************************************************************************************ // 





	// ************************************ constructors here ***************************************** //
	// ************************************************************************************************ //
		public Build(boolean f)
		{
			if (f== true)
			parts.add(gp_part);
			temp.add(gp_part.getType());
			build_size = parts.size();
			//temp_size = temp.size();
		}

		public Build(int ind, int ch)
		{
			if (ch ==1)
			{
				parts.remove(ind);
				temp.remove(ind);
				
			}


		}

		public Build()
		{
			complete_build();
		}
	// ***************************************** end of constructors ********************************** //
	// ************************************************************************************************ // 

		

	// ***************************************** methods here ***************************************** //
	// ************************************************************************************************ //


			// ****************************** pritner methods ********************* //
			// ******************************************************************** //

				public void printBuild_1()
				{
					System.out.println("Let's build a 1337 box!");
					System.out.print("Enter choice (n/a/r/v/c/x): ");
				}


				public void printBuild_2()
				{
					System.out.print("Enter choice (n/a/r/v/c/x): ");
				}


				private static void helpMenu()
				{
					System.out.println("n = start a new build (clears old build)");
					System.out.println("a = add a part from the catalogue to the build");
					System.out.println("r = remove a part from the build");
					System.out.println("v = show the current state of the build");
					System.out.println("c = check if the build is a functional computer");
					System.out.println("? = this help message");

				}

				private static void showBuild()
				{
					if (build_size > 0)
					{
						for(int j=0; j <build_size;j++)
						{
							System.out.println((j+1)+ ". " + parts.get(j));
						}

						String h = formatted(total_price);
						System.out.println("Total Price: $" + h );
					}

					else 
					{
						String h = formatted(total_price);
						System.out.println("Total Price: $" + h );

					}

					//System.out.println(complete_set);

					
					

				}

			// ****************************** end pritner methods ***************** //
			// ******************************************************************** //




			// ****************************** selector method ********************* //
			// ******************************************************************** //

				public void buildSelect(char in)
				{
					switch(in)
					{
						case 'n':
							//System.out.println("before " + parts);
							parts.removeAll(parts);
							total_price = 0;
							build_size = 0;

							
							//System.out.println("total_price" + total_price+ "build size " + build_size);
							//System.out.println("after " + parts);
							break;
						case 'a':
							addPart();
							break;

						case 'r':
							removePart();
							break;

						case 'v':
							showBuild();
							break;

						case 'c':
							isValid();
							break;

						case 'x':
							
							break;

						case 63:
							helpMenu();
							break;
							
						default: 
							break;
					}
				}

			// ****************************** end selector method ***************** //
			// ******************************************************************** //



			// ****************************** add method ************************** //
			// ******************************************************************** //
				
				public void addPart()
				{
					System.out.print("Enter catalogue number of the part: ");
					index = In.nextInt();
					if (index > 0 && index <= cat_size)
					{
						for (int i =0; i<cat_size; i++)
						{
							if (i == index-1)
							{
								flag = true;
								gp_part = Catalogue.getPart(i);

								total_price += Catalogue.getPrice(i);
								new Build(flag);
							}

						}
					}

					else 
					{
						System.out.println("There is no part by that number.");
					}

					
				}

			// ****************************** end adder method ******************** //
			// ******************************************************************** //


	
			// ****************************** format method *********************** //
			// ******************************************************************** //

				private static String formatted(double money) 
				{
					String k = new DecimalFormat("#####0.00").format(money);
					return k;

				}

			// ****************************** end format method ******************* //
			// ******************************************************************** //

			// ****************************** remover method ********************** //
			// ******************************************************************** //
				private static void removePart()
				{
					
					System.out.print("Enter number of part to remove: ");
					index = In.nextInt();
					if (index > 0 && index <= build_size)
					{
						remove_check =1;
						remove_index = index;
						gp_part = parts.get(index-1);
						double jah = gp_part.getPrice();
						total_price -= jah;
						new Build(remove_index-1, remove_check);

						
						
						build_size-=1;
						
						
						 
						
					}

					else 
					{
						System.out.println("The build has no part with that number.");
					}
					

				}

			// ****************************** end remover method ****************** //
			// ******************************************************************** //



			// ****************************** checker  method ********************* //
			// ******************************************************************** //
				
				private static void isValid()
				{	
					
					for (int d=0;d<5;d++)
					{
						copy.add(complete_set.get(d));
					}

						//System.out.println(complete_set);
						//System.out.println("copy before "+copy);
						//System.out.println(temp);

					
				
					
					copy.removeAll(temp);
					//System.out.println("copy after "+copy);
					//System.out.print(complete_set);
					temp_size = copy.size();
					String d; 

					if (temp_size != 0)
					{
						for (int f =0;f<temp_size;f++)
						{
							d = copy.get(f);
							if (d.equals("STORAGE") == true)
							{
								d = d.toLowerCase();
								System.out.println("The build is missing "+d+".");
							}

							else if (d.equals("MEMORY") == true)
							{
								System.out.println("The build is missing RAM.");
							}

							else 
							{
								d= d.toLowerCase();
								System.out.println("The build is missing a " + d+".");
							}

						}
					}

					else System.out.println("The build is functional.");





					

					



				}

				private static void complete_build()
				{
				
					complete_set.add("MOTHERBOARD");
					complete_set.add( "CPU");
					complete_set.add("MEMORY");
					complete_set.add("STORAGE");
					complete_set.add( "CASE");
					
					
					

				}

			// ****************************** end checker  method ***************** //
			// ******************************************************************** //


	

	// ***************************************** end of methods *************************************** //
	// ************************************************************************************************ //
		
}