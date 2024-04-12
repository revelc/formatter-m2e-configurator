# formatter-m2e-configurator

[![mvn verify][ci_img]][ci_link]
[![Maven Central][maven_img]][maven_link]
[![Apache License][license_img]][license_link]

This project provides an [m2e] project configurator for the
[formatter-maven-plugin], so that if you import your project into [Eclipse] as
a [Maven] project using m2e, you can have your project settings match the Maven
plugin settings.

## Manual Installation Process

To use this project, download the site zip artifact from maven central then use the zip to import configurator into Eclipse.

Directly trying to do this from maven central will fail with missing jars.

To use this since we are not well versed on how to get the site zip into github currently, please use these instructions:

- download https://repo1.maven.org/maven2/net/revelc/code/formatter/net.revelc.code.formatter.site/2.6.4/net.revelc.code.formatter.site-2.6.4.zip from maven central.
- Then in eclipse, use Add Repository in available software using archive option and adding the zip file.
- Accept any prompts during the process to successfully install it into Eclipse

M2e related items
- [related1] M2e Extension Development
- [related2] M2e Discovery Catalog
- [related3] M2e Discovery File location to submit to via pull request
- [related4] Eclipse PReference - Tutorial

This software is provided WITHOUT ANY WARRANTY, and is available under the
Apache License, Version 2. Any code loss caused by using this plugin is not the
responsibility of the author(s). Be sure to use some source repository
management system such as GIT before using this plugin.

Contributions are welcome.

[Eclipse]: https://eclipse.org
[Maven]: https://maven.apache.org
[ci_img]: https://github.com/revelc/formatter-m2e-configurator/workflows/mvn%20verify/badge.svg
[ci_link]: https://github.com/revelc/formatter-m2e-configurator/actions
[formatter-maven-plugin]: https://github.com/revelc/formatter-maven-plugin
[license_img]: https://img.shields.io/badge/license-Apache%202.0-blue.svg
[license_link]: https://github.com/revelc/formatter-m2e-configurator/blob/main/LICENSE
[m2e]: https://eclipse.org/m2e
[maven_img]: https://maven-badges.herokuapp.com/maven-central/net.revelc.code.formatter/formatter-m2e-configurator/badge.svg
[maven_link]: https://maven-badges.herokuapp.com/maven-central/net.revelc.code.formatter/formatter-m2e-configurator
[related1]: https://eclipse.dev/m2e/documentation/m2e-extension-development.html
[related2]: https://github.com/takari/m2e-discovery-catalog/
[related3]: https://github.com/takari/m2e-discovery-catalog/blob/master/org.eclipse.m2e.discovery.oss/src/main/resources-filtered/connectors.xml
[related4]: https://www.vogella.com/articles/EclipsePreferences/article.html
