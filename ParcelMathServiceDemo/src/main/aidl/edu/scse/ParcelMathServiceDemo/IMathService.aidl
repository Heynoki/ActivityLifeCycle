// IMathService.aidl
package edu.scse.ParcelMathServiceDemo;

// Declare any non-default types here with import statements
import edu.scse.ParcelMathServiceDemo.AllResult;
interface IMathService {
    long Add(long a, long b);
   AllResult ComputeAll(long a, long b);
}