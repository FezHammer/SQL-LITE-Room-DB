# SQLLite-Room_DB

--Table Set up
@Entity
public class Items {
    @NonNull
    @PrimaryKey(autoGenerate = true)
    private int id;


    private String first ;
    private String last ;
    
    --(Set And Get)
    
     --interface class for Database access
    
    @Dao
public interface MayDao {

@Insert
void addItem(Items items);

@Query ("select * from Items")
List<Items> getItems();

@Delete
void deleteitem(Items items);

-- Database class for database implementation

@Database(entities = {Items.class}, version = 1)
public abstract class MyAppDataBase extends RoomDatabase {
    public abstract MyDao daoAccess() ;
    
-- Example Room With Saving, Loading and Deleting 

 private static final String DATABASE_NAME = "items_test_db";
    private static MyAppDataBase myAppDataBase;
    TextView txtDB;
    EditText txtID, txtFirst, txtLast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myAppDataBase = Room.databaseBuilder(getApplicationContext(),MyAppDataBase.class , DATABASE_NAME).allowMainThreadQueries().build();
        txtDB = findViewById(R.id.txtDB);
        txtID = findViewById(R.id.txtID);
        txtFirst = findViewById(R.id.txtFirst);
        txtLast = findViewById(R.id.txtLast);

    }






    public void testSaveDB (View view){
    String first = txtFirst.getText().toString();
    String last = txtLast.getText().toString();
    Items book = new Items();
    book.setFirst(first);
    book.setLast(last);
    myAppDataBase.daoAccess().addItem(book);
    }
     public  void TestReadDB (View view){

         List<Items> items = myAppDataBase.daoAccess().getItems();
         String Temp = "";
         for (Items item : items){
                int id = item.getId();
             String first = item.getFirst();
             String last = item.getLast();
             Temp = Temp + "\n\n"+"ID :"+id+"\n First Name :"+first+"\n Last Name :" + last;



         }




         txtDB.setText(Temp);

     }

     public void DeleteDbItems(View view){
        int id = Integer.parseInt(txtID.getText().toString());
        Items item = new Items();
        item.setId(id);
        myAppDataBase.daoAccess().deleteitem(item);
        TestReadDB(null);
     }





}
