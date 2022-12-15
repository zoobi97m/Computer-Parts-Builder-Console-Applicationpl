import java.util.ArrayList;
import java.util.LinkedList;

import java.util.List;

public class Catalogue 
{
	// ************************************** enter fields here *************************************** //
	// ************************************************************************************************ //
		private static LinkedList<Part> parts = new LinkedList<Part>();
		// linked list of parts // 
	// ******************************************* end of fields ************************************** //
	// ************************************************************************************************ // 

    	private static int size;
		private static String add_name;
		private static String  add_type;
		private static double add_price;
		private static boolean flag_1;
		private static int index;
		private static int check;
		private static String filter_type;
		private static double filter_price_min;
		private static double filter_price_max;

		private static Part myPart; 




    


	// ************************************ constructors here ***************************************** //
	// ************************************************************************************************ //
			public Catalogue()
			{
				// create 7 instances for each part  // 
				
				parts.add(new Part("evo 860", "STORAGE", 155));
				parts.add(new Part("daskeyboard", "KEYBOARD", 239 ));
				parts.add(new Part("i5", "CPU", 365));
				parts.add(new Part("corsair 16G", "MEMORY", 299 ));
				parts.add(new Part("ASUS ROG", "MOTHERBOARD", 159));
				parts.add(new Part("sheetmetal box", "CASE", 39));
				parts.add(new Part("Ryzen 7", "CPU", 299)); 
				
				size = parts.size();
				
			}

			public Catalogue(boolean f)
			{
				// create 7 instances for each part  // 
				
				if(f == true)
				{
					parts.add(new Part(add_name, add_type, add_price)); 
				}
				
				size = parts.size();
				
			}

			public Catalogue(int ind, int ch)
			{
				if (ch ==1)
				{
					parts.remove(ind);
				}


			}



	// ***************************************** end of constructors ********************************** //
	// ************************************************************************************************ // 




	

	// ***************************************** methods here ***************************************** //
	// ************************************************************************************************ //


		// ******************** printer methods ******************** //
		// ********************************************************* //

			public void printCatalogue_1()
			{
				System.out.println("Welcome to the parts catalogue.");
				System.out.print("Enter choice (a/r/s/f/x): ");
			}


			public void printCatalogue_2()
			{
				System.out.print("Enter choice (a/r/s/f/x): ");
			}

			private static void helpMenu()
			{
				
				System.out.println("a = add a new part to the catalogue");
				System.out.println("r = remove a part from the catalogue");
				System.out.println("s = show the catalogue");
				System.out.println("f = show a filtered view of the catalogue");
				System.out.println("? = this help message");

			}

			private static void showParts()
			{
				for(int x=0;x<size;x++)
				{
					
					System.out.println((x+1)+". " + parts.get(x));
				}
				
				size = parts.size();
				
				
			}

		// **************** end printer methods ******************** //
		// ********************************************************* //
		


		// ******************** selector method ******************** //
		// ********************************************************* //


				public void catSelect(char in)
				{
					switch(in)
					{
						case 'a':
							flag_1 = true;
							adder();
							new Catalogue(flag_1);

							break;

						case 'r':
							
							removePart();

							break;
						

						case 's':
							showParts();
							break;

						case 'f':
							filter();
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

		// **************** end selector methods ******************** //
		// ********************************************************** //




		// ******************** adder method *********************** //
		// ********************************************************* //

			public void adder()
			{
				System.out.print("Enter part name: ");
					add_name = In.nextLine();
				System.out.print("Enter part type: ");
					add_type = In.nextLine();
					add_type = add_type.toUpperCase();
				System.out.print("Enter part price: ");
					add_price = In.nextDouble();



			}

		// **************** end adder methods *********************** //
		// ********************************************************** //



		// ******************** remover method ********************** //
		// ********************************************************** //

			public void removePart()
			{
				
				System.out.print("Enter catalogue number of part to remove: ");
					index = In.nextInt();

					if (index >= 1 && index <= size )
					{
						check = 1;
						new Catalogue(index-1, check);
						size -= 1;

					}
					else System.out.println("The catalogue has no part with that number.");
				



			}

		// **************** end remover method ********************** //
		// ********************************************************** //



		// ******************** fliter methods ********************** //
		// ********************************************************** //

				public void filter()
				{
					System.out.print("Enter type of part to view ('all' for no filtering): ");
					filter_type = In.nextLine();
					String no_type_filter = "all";


						if (filter_type.equals(no_type_filter) == false) // if user did not select all (type true)
						{

							// ask if he wants to filer by price as well 
							System.out.print("Enter minimum price ('-1' for no filtering): ");
							filter_price_min = In.nextDouble();

							// trial 1 // 
							filter_type = filter_type.toUpperCase();


							// if the user selected  -1 (filter by type only )
							if (filter_price_min == -1)
							{
								for (int u=0; u<size;u++)
								{
									myPart = parts.get(u);
									String my = myPart.getType();
									my = my.toUpperCase();
									if (my.equals(filter_type) == true)
									{
										System.out.println((u+1) + ". " + myPart);
									}
								}
							}
							
							else 
							{
								filterBoth(); //filter by type and price 
							}
							
						}


						// filter by price only // 
						
						else 
						{
							filterByPrice();
						}
					

				}


				
				
				public void filterByPrice()
				{
					System.out.print("Enter minimum price ('-1' for no filtering): ");
					filter_price_min = In.nextDouble();


					if (filter_price_min != -1)
					{
						System.out.print("Enter maximum price: ");
						filter_price_max = In.nextDouble();

						if (filter_price_min < filter_price_max )
						{
							for (int k= 0; k<size;k++)
							{
								myPart = parts.get(k);
								double hold = myPart.getPrice();
								if (hold >= filter_price_min && hold <= filter_price_max)
								{
									System.out.println((k+1) + ". " + myPart);

								}
							}
						}
						else if (filter_price_min == filter_price_max)
						{

						}

						else 
						{
							System.out.println("Minimum price shouldn't be greater than maximum price.");
						}
					}

							
					else 
					{ 
						showParts(); // if he does enter -1 , print everything 

					}


				}
				
				public void filterBoth()
				{
                    System.out.print("Enter maximum price: ");
                    filter_price_max = In.nextDouble();



                    for (int m=0; m<size;m++)
                    {
                        myPart = parts.get(m);
                        String my = myPart.getType();
                        my = my.toUpperCase();
                        if (my.equals(filter_type) == true)
                        {
                            if (filter_price_min < filter_price_max )
                            {
                                double hold = myPart.getPrice();
                                if (hold >= filter_price_min && hold <= filter_price_max)
                                {
                                    System.out.println((m+1) + ". " + myPart);

                                }

                            }

                            // if theyre equal, just filter by type ? 

                           
                        }
                    }
					
				}

				

		// **************** end filter methods ********************** //
		// ********************************************************** //


	
		

	
	// ***************************************** end of methods *************************************** //
	// ************************************************************************************************ //
}