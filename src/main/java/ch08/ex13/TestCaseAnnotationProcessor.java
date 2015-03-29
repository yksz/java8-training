package ch08.ex13;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.tools.JavaFileObject;

/**
 * usage:
 * <pre>
 * javac ch08/ex13/TestCaseAnnotationProcessor.java
 * javac -processor ch08.ex13.TestCaseAnnotationProcessor ch08.ex13.Calculator
 * </pre>
 */
@SupportedSourceVersion(SourceVersion.RELEASE_8)
@SupportedAnnotationTypes({"ch08.ex13.TestCases"})
public class TestCaseAnnotationProcessor extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        for (TypeElement annotation : annotations) {
            String className = null;
            Map<Element, TestCase[]> props = new LinkedHashMap<>();
            for (Element element : roundEnv.getElementsAnnotatedWith(annotation)) {
                if (className == null)
                    className = element.getEnclosingElement().toString();
                TestCase[] testCases = element.getAnnotationsByType(TestCase.class);
                if (testCases.length != 0)
                    props.put(element, testCases);
            }
            try {
                if (className != null)
                    writeTestClass(className, props);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    private void writeTestClass(String fqcn, Map<Element, TestCase[]> props) throws IOException {
        String testFqcn = fqcn + "Test";
        JavaFileObject sourceFile = processingEnv.getFiler().createSourceFile(testFqcn);
        PrintWriter out = new PrintWriter(sourceFile.openWriter());
        int i = testFqcn.lastIndexOf(".");
        if (i > 0) {
            out.print("package ");
            out.print(testFqcn.substring(0, i));
            out.println(";");
        }
        out.println();

        String testClassName = testFqcn.substring(i + 1);
        out.print("public class ");
        out.print(testClassName);
        out.println("{");

        writeAssertTrueMethod(out);
        List<String> testMethodNames = writeTestMethod(out, fqcn.substring(i + 1), props);
        writeMainMethod(out, testMethodNames);

        out.println("}");
        out.close();
    }

    private void writeAssertTrueMethod(PrintWriter out) {
        out.println("    static void assertTrue(String message, boolean condition) {");
        out.println("        if (!condition)");
        out.println("            System.err.println(message);");
        out.println("    }");
        out.println();
    }

    private List<String> writeTestMethod(PrintWriter out, String className, Map<Element, TestCase[]> props) {
        List<String> testMethodNames = new ArrayList<>();
        for (Element element : props.keySet()) {
            String methodName = element.getSimpleName().toString();
            String testMethodName = "test_" + methodName;
            testMethodNames.add(testMethodName);
            out.print("    static void ");
            out.print(testMethodName);
            out.println("() {");
            for (TestCase testCase : props.get(element)) {
                boolean isStatic = element.getModifiers().contains(Modifier.STATIC);
                String testExpression = createTestExpression(isStatic, className, methodName, testCase);
                out.print("        assertTrue(\"FAILED: ");
                out.print(testExpression);
                out.print("\", ");
                out.print(testExpression);
                out.println(");");
            }
            out.println("    }");
            out.println();
        }
        return testMethodNames;
    }

    private String createTestExpression(boolean isStatic, String className, String methodName,
            TestCase testCase) {
        StringBuffer sb = new StringBuffer();
        if (isStatic) {
            sb.append(className);
        } else {
            sb.append("new ");
            sb.append(className);
            sb.append("()");
        }
        sb.append(".");
        sb.append(methodName);
        sb.append("(");
        int[] params = testCase.params();
        sb.append(params[0]);
        for (int i = 1; i < params.length; i++) {
            sb.append(", ");
            sb.append(params[i]);
        }
        sb.append(")");
        sb.append(" == ");
        sb.append(testCase.expected());
        return sb.toString();
    }

    private void writeMainMethod(PrintWriter out, List<String> testMethodNames) {
        out.println("    public static void main(String[] args) {");
        for (String testMethodName : testMethodNames) {
            out.print("        ");
            out.print(testMethodName);
            out.println("();");
        }
        out.println("    }");
    }

}
