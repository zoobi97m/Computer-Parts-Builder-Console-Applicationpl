public class ComputerBuilder 

{
	public static void main(String args[])
	{
		//new ComputerBuilder();
		printMenu();
		System.out.print("Select option: ");

		char user_input = In.nextChar();
		selector(user_input);

	
		while (user_input != '3')
		{
			printMenu_2();
			System.out.print("Select option: ");
			user_input = In.nextChar();
			selector(user_input);

		}

		
		


	}

	// ************************************** enter fields here *************************************** //
	// ************************************************************************************************ //
		private static Catalogue catalogue = new Catalogue(); // instance of the catalogue class 
		private static Build currentBuild = new Build();	 // instance of the build class 
		
	// ******************************************* end of fields ************************************** //
	// ************************************************************************************************ // 



	// ************************************ constructors here ***************************************** //
	// ************************************************************************************************ //
		public ComputerBuilder()
		{

		}

	// ***************************************** end of constructors ********************************** //
	// ************************************************************************************************ // 

	

	// ***************************************** methods here ***************************************** //
	// ************************************************************************************************ //
		
		
		private static void printMenu()
		{
			System.out.println("Welcome to Jaime's Computer Store");
			System.out.println("Quality Parts at the Best Prices");
			System.out.println("=================================");
			System.out.println("1. Catalogue Menu");
			System.out.println("2. Build Menu");
			System.out.println("3. Exit");
			

			
			
		}

		private static void printMenu_2()
		{
			System.out.println("1. Catalogue Menu");
			System.out.println("2. Build Menu");
			System.out.println("3. Exit");
		}


		private static void selector(char input)
		{	

			switch(input)
			{
				case '1':	

					catalogue.printCatalogue_1();
					char cat_input = In.nextChar();
					catalogue.catSelect(cat_input);

					while(cat_input != 'x')
					{
						catalogue.printCatalogue_2();
						cat_input = In.nextChar();
						catalogue.catSelect(cat_input);

					}

					break;


				case '2':
				
				currentBuild.printBuild_1();
				char build_input = In.nextChar();
				currentBuild.buildSelect(build_input);
				while (build_input != 'x')
				{
					currentBuild.printBuild_2();
					build_input = In.nextChar();
					currentBuild.buildSelect(build_input);
				}

					break;

				case '3': 
					System.out.println("Done");

					System.exit(0);
					break;
				case 63:
					helpMenu_main();
					break;

				default:
					break;

			}
		}

		private static void helpMenu_main()
		{
			System.out.println("1 = interact with the catalogue");
			System.out.println("2 = build your computer!");
			System.out.println("? = this help message");
			//System.out.println("3. Exit");
		}

	// ***************************************** end of methods *************************************** //
	// ************************************************************************************************ // 



}