package patterns.templatemethod;

/**
 * Паттерн "Шаблонный метод"
 * Задает "скелет" алгоритма в методе, оставляя определение реализации некоторых шагов субклассам.
 * Субклассы могут переопределять некоторые части алгоритма без изменения его структуры.
 */
public class TemplateMethodApp {

    public static void main(String[] args) {
        CompanyRepository companyRepo = new CompanyRepository();

        CompanyRepository.Company company = companyRepo
                .query("select * from company where id = %d limit 1", 555);
    }

}
