/*
 * MATLAB Compiler: 6.2 (R2016a)
 * Date: Wed Jun 27 15:28:30 2018
 * Arguments: "-B" "macro_default" "-W" "java:matlab,matlab" "-T" "link:lib" "-d" 
 * "D:\\WorkSpace\\MatLab\\add\\for_testing" 
 * "class{matlab:D:\\WorkSpace\\MatLab\\add.m,D:\\WorkSpace\\MatLab\\ims.m}" 
 */

package matlab;

import com.mathworks.toolbox.javabuilder.*;
import com.mathworks.toolbox.javabuilder.internal.*;
import java.util.*;

/**
 * The <code>matlab</code> class provides a Java interface to the M-functions
 * from the files:
 * <pre>
 *  D:\\WorkSpace\\MatLab\\add.m
 *  D:\\WorkSpace\\MatLab\\ims.m
 * </pre>
 * The {@link #dispose} method <b>must</b> be called on a <code>matlab</code> instance 
 * when it is no longer needed to ensure that native resources allocated by this class 
 * are properly freed.
 * @version 0.0
 */
public class matlab extends MWComponentInstance<matlab>
{
    /**
     * Tracks all instances of this class to ensure their dispose method is
     * called on shutdown.
     */
    private static final Set<Disposable> sInstances = new HashSet<Disposable>();

    /**
     * Maintains information used in calling the <code>add</code> M-function.
     */
    private static final MWFunctionSignature sAddSignature =
        new MWFunctionSignature(/* max outputs = */ 2,
                                /* has varargout = */ false,
                                /* function name = */ "add",
                                /* max inputs = */ 2,
                                /* has varargin = */ false);
    /**
     * Maintains information used in calling the <code>ims</code> M-function.
     */
    private static final MWFunctionSignature sImsSignature =
        new MWFunctionSignature(/* max outputs = */ 1,
                                /* has varargout = */ false,
                                /* function name = */ "ims",
                                /* max inputs = */ 2,
                                /* has varargin = */ false);

    /**
     * Shared initialization implementation - private
     */
    private matlab (final MWMCR mcr) throws MWException
    {
        super(mcr);
        // add this to sInstances
        synchronized(matlab.class) {
            sInstances.add(this);
        }
    }

    /**
     * Constructs a new instance of the <code>matlab</code> class.
     */
    public matlab() throws MWException
    {
        this(MatlabMCRFactory.newInstance());
    }
    
    private static MWComponentOptions getPathToComponentOptions(String path)
    {
        MWComponentOptions options = new MWComponentOptions(new MWCtfExtractLocation(path),
                                                            new MWCtfDirectorySource(path));
        return options;
    }
    
    /**
     * @deprecated Please use the constructor {@link #matlab(MWComponentOptions componentOptions)}.
     * The <code>com.mathworks.toolbox.javabuilder.MWComponentOptions</code> class provides API to set the
     * path to the component.
     * @param pathToComponent Path to component directory.
     */
    public matlab(String pathToComponent) throws MWException
    {
        this(MatlabMCRFactory.newInstance(getPathToComponentOptions(pathToComponent)));
    }
    
    /**
     * Constructs a new instance of the <code>matlab</code> class. Use this constructor 
     * to specify the options required to instantiate this component.  The options will 
     * be specific to the instance of this component being created.
     * @param componentOptions Options specific to the component.
     */
    public matlab(MWComponentOptions componentOptions) throws MWException
    {
        this(MatlabMCRFactory.newInstance(componentOptions));
    }
    
    /** Frees native resources associated with this object */
    public void dispose()
    {
        try {
            super.dispose();
        } finally {
            synchronized(matlab.class) {
                sInstances.remove(this);
            }
        }
    }
  
    /**
     * Invokes the first m-function specified by MCC, with any arguments given on
     * the command line, and prints the result.
     */
    public static void main (String[] args)
    {
        try {
            MWMCR mcr = MatlabMCRFactory.newInstance();
            mcr.runMain( sAddSignature, args);
            mcr.dispose();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
    
    /**
     * Calls dispose method for each outstanding instance of this class.
     */
    public static void disposeAllInstances()
    {
        synchronized(matlab.class) {
            for (Disposable i : sInstances) i.dispose();
            sInstances.clear();
        }
    }

    /**
     * Provides the interface for calling the <code>add</code> M-function 
     * where the first input, an instance of List, receives the output of the M-function and
     * the second input, also an instance of List, provides the input to the M-function.
     * @param lhs List in which to return outputs. Number of outputs (nargout) is
     * determined by allocated size of this List. Outputs are returned as
     * sub-classes of <code>com.mathworks.toolbox.javabuilder.MWArray</code>.
     * Each output array should be freed by calling its <code>dispose()</code>
     * method.
     *
     * @param rhs List containing inputs. Number of inputs (nargin) is determined
     * by the allocated size of this List. Input arguments may be passed as
     * sub-classes of <code>com.mathworks.toolbox.javabuilder.MWArray</code>, or
     * as arrays of any supported Java type. Arguments passed as Java types are
     * converted to MATLAB arrays according to default conversion rules.
     * @throws MWException An error has occurred during the function call.
     */
    public void add(List lhs, List rhs) throws MWException
    {
        fMCR.invoke(lhs, rhs, sAddSignature);
    }

    /**
     * Provides the interface for calling the <code>add</code> M-function 
     * where the first input, an Object array, receives the output of the M-function and
     * the second input, also an Object array, provides the input to the M-function.
     * @param lhs array in which to return outputs. Number of outputs (nargout)
     * is determined by allocated size of this array. Outputs are returned as
     * sub-classes of <code>com.mathworks.toolbox.javabuilder.MWArray</code>.
     * Each output array should be freed by calling its <code>dispose()</code>
     * method.
     *
     * @param rhs array containing inputs. Number of inputs (nargin) is
     * determined by the allocated size of this array. Input arguments may be
     * passed as sub-classes of
     * <code>com.mathworks.toolbox.javabuilder.MWArray</code>, or as arrays of
     * any supported Java type. Arguments passed as Java types are converted to
     * MATLAB arrays according to default conversion rules.
     * @throws MWException An error has occurred during the function call.
     */
    public void add(Object[] lhs, Object[] rhs) throws MWException
    {
        fMCR.invoke(Arrays.asList(lhs), Arrays.asList(rhs), sAddSignature);
    }

    /**
     * Provides the standard interface for calling the <code>add</code>
     * M-function with 2 input arguments.
     * Input arguments may be passed as sub-classes of
     * <code>com.mathworks.toolbox.javabuilder.MWArray</code>, or as arrays of
     * any supported Java type. Arguments passed as Java types are converted to
     * MATLAB arrays according to default conversion rules.
     *
     * @param nargout Number of outputs to return.
     * @param rhs The inputs to the M function.
     * @return Array of length nargout containing the function outputs. Outputs
     * are returned as sub-classes of
     * <code>com.mathworks.toolbox.javabuilder.MWArray</code>. Each output array
     * should be freed by calling its <code>dispose()</code> method.
     * @throws MWException An error has occurred during the function call.
     */
    public Object[] add(int nargout, Object... rhs) throws MWException
    {
        Object[] lhs = new Object[nargout];
        fMCR.invoke(Arrays.asList(lhs), 
                    MWMCR.getRhsCompat(rhs, sAddSignature), 
                    sAddSignature);
        return lhs;
    }
    /**
     * Provides the interface for calling the <code>ims</code> M-function 
     * where the first input, an instance of List, receives the output of the M-function and
     * the second input, also an instance of List, provides the input to the M-function.
     * @param lhs List in which to return outputs. Number of outputs (nargout) is
     * determined by allocated size of this List. Outputs are returned as
     * sub-classes of <code>com.mathworks.toolbox.javabuilder.MWArray</code>.
     * Each output array should be freed by calling its <code>dispose()</code>
     * method.
     *
     * @param rhs List containing inputs. Number of inputs (nargin) is determined
     * by the allocated size of this List. Input arguments may be passed as
     * sub-classes of <code>com.mathworks.toolbox.javabuilder.MWArray</code>, or
     * as arrays of any supported Java type. Arguments passed as Java types are
     * converted to MATLAB arrays according to default conversion rules.
     * @throws MWException An error has occurred during the function call.
     */
    public void ims(List lhs, List rhs) throws MWException
    {
        fMCR.invoke(lhs, rhs, sImsSignature);
    }

    /**
     * Provides the interface for calling the <code>ims</code> M-function 
     * where the first input, an Object array, receives the output of the M-function and
     * the second input, also an Object array, provides the input to the M-function.
     * @param lhs array in which to return outputs. Number of outputs (nargout)
     * is determined by allocated size of this array. Outputs are returned as
     * sub-classes of <code>com.mathworks.toolbox.javabuilder.MWArray</code>.
     * Each output array should be freed by calling its <code>dispose()</code>
     * method.
     *
     * @param rhs array containing inputs. Number of inputs (nargin) is
     * determined by the allocated size of this array. Input arguments may be
     * passed as sub-classes of
     * <code>com.mathworks.toolbox.javabuilder.MWArray</code>, or as arrays of
     * any supported Java type. Arguments passed as Java types are converted to
     * MATLAB arrays according to default conversion rules.
     * @throws MWException An error has occurred during the function call.
     */
    public void ims(Object[] lhs, Object[] rhs) throws MWException
    {
        fMCR.invoke(Arrays.asList(lhs), Arrays.asList(rhs), sImsSignature);
    }

    /**
     * Provides the standard interface for calling the <code>ims</code>
     * M-function with 2 input arguments.
     * Input arguments may be passed as sub-classes of
     * <code>com.mathworks.toolbox.javabuilder.MWArray</code>, or as arrays of
     * any supported Java type. Arguments passed as Java types are converted to
     * MATLAB arrays according to default conversion rules.
     *
     * @param nargout Number of outputs to return.
     * @param rhs The inputs to the M function.
     * @return Array of length nargout containing the function outputs. Outputs
     * are returned as sub-classes of
     * <code>com.mathworks.toolbox.javabuilder.MWArray</code>. Each output array
     * should be freed by calling its <code>dispose()</code> method.
     * @throws MWException An error has occurred during the function call.
     */
    public Object[] ims(int nargout, Object... rhs) throws MWException
    {
        Object[] lhs = new Object[nargout];
        fMCR.invoke(Arrays.asList(lhs), 
                    MWMCR.getRhsCompat(rhs, sImsSignature), 
                    sImsSignature);
        return lhs;
    }
}
