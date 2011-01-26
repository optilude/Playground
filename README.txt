This is a dummy application that illustrates some patterns with the Play!
framework.

To test, install Play 1.1.1 and the Guice module. In the Guice module, replace
the Guice JARs with the guice 3.0rc2 versions from http://code.google.com/p/google-guice.

Make sure guice-multibindings-3.0rc2.jar is included, or put it in the lib/
directory in the project.

Check out http://code.google.com/p/jadapter from svn and build it with maven.
Then copy the built jadapter.jar to the lib/ directory of the project.