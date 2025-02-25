/******************************************************************************
 * Rule 02. Expressions (EXP)
 * XP00-J. Do not ignore values returned by methods
 *
 ******************************************************************************/
public void deleteFile(){
 
  File someFile = new File("someFileName.txt");
  // Do something with someFile
  someFile.delete();
 
}