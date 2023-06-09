package cc.unitmesh.core.java

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class SpringProcessorTest {
    private val SampleClass = """
                package org.unitmesh.processor.java;
                
                import org.springframework.web.bind.annotation.RequestMapping;
                import org.springframework.web.bind.annotation.RestController;
                
                @RestController
                public class JavaProcessor {
                    @RequestMapping("/test")
                    public String test() {
                        return "test";
                    }
                }
            """

    @Test
    fun `search spring class`() {
        val code = SampleClass.trimIndent()
        val processor = SpringProcessor(code)
        processor.isSpringController() shouldBe true
    }
}