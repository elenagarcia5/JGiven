package com.tngtech.jgiven.report.html;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;

import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.report.ThenReportGenerator;
import com.tngtech.jgiven.report.model.ReportModel;

public class ThenStaticHtmlReportGenerator<SELF extends ThenStaticHtmlReportGenerator<?>> extends ThenReportGenerator<SELF> {

    @ExpectedScenarioState
    protected File customCssFile;

    public SELF an_index_file_exists() {
        return a_file_with_name_$_exists( "index.html" );
    }

    public SELF an_HTML_file_exists_for_each_test_class() {
        for( ReportModel model : reportModels ) {
            a_file_with_name_$_exists( model.className + ".html" );
        }
        return self();
    }

    public SELF the_custom_CSS_file_is_copied_to_the_target_directory() {
        assertThat( new File( targetReportDir, customCssFile.getName() ) ).exists();
        return self();
    }
}
