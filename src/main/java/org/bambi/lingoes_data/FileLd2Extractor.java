package org.bambi.lingoes_data;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public abstract class FileLd2Extractor extends Ld2Extractor {

  private BufferedWriter outputWriter = null;


  protected abstract String getOutputFileName();


  @Override
  protected void beforeTranslation() {
    try {
      outputWriter = new BufferedWriter(new FileWriter(getOutputFileName()), Helper.BUFFER_SIZE);
    }
    catch(IOException exception) {
      throw new RuntimeException("Failed to open Output file: " + getOutputFileName(), exception);
    }
  }


  @Override
  protected void afterTranslation() {
    try {
      if(outputWriter != null)
        outputWriter.close();
    }
    catch(IOException exception) {
      throw new RuntimeException("Failed to close Output file: " + getOutputFileName(), exception);
    }
    finally {
      outputWriter = null;
    }
  }

  
  protected void writeToFile(String text) {
    try {
      outputWriter.write(String.format("%s\r\n", text));
    }
    catch(IOException exception) {
      throw new RuntimeException("Failed to write Output file: " + getOutputFileName(), exception);
    }
  }
  
}
