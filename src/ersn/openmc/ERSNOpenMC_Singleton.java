/*
 * The MIT License
 *
 * Copyright 2015 Jaafar EL Bakkali.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package ersn.openmc;

/**
 *
 * @author elbakkali
 */
public class ERSNOpenMC_Singleton {
 String path=""; static String OpenMCpath="";
private static ERSNOpenMC_Singleton singleton = new ERSNOpenMC_Singleton( );
   
   /* A private Constructor prevents any other 
    * class from instantiating.
    */
   private ERSNOpenMC_Singleton(){ }
   
   /* Static 'instance' method */
   public static ERSNOpenMC_Singleton getInstance( ) {
      return singleton;
   }
   
   /* Other methods protected by singleton-ness */
   
   public String getPath ( ) {

   return path;
   }
  
    public String getOpenMCPath ( ) {

   return OpenMCpath;
   }
    
    public void  setPath ( String _path) {

  path=_path;
   } 
   public void  setOpenMCPath ( String _path) {

  OpenMCpath=_path;
   }  
   
}
