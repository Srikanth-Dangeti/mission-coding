package Alltrees;

import java.util.ArrayList;

public class Test1 {

	public static void main(String []args)
	{
		Boolean test[] = new Boolean[5];
		//System.out.println(test[0]);
		//int a[] = new int[1];
		
		for(int i = 1 ; i< 212 ; i++)
		{
			String str = "MERGE|Organization|2019/01/01|4712/12/31|PJF_FEB_23_ORG_"+i+"|DEPARTMENT|Department|||HRC_SQLLOADER|PJF_FEB_23_SYSID_"+i;
			//System.out.println(str);
			
			String str1 = "MERGE|OrgUnitClassification|2019/01/01|4712/12/31|PJF_FEB_23_ORG_"+i+"|DEPARTMENT|Department|0||HRC_SQLLOADER|PJF_FEB_23_SYS_ID_"+i+"|A";
			//System.out.println(str1);
			
			String str2 = "MERGE|OrgUnitClassification|2019/01/01|4712/12/31|PJF_FEB_23_SYSID_"+i+"|PA_PROJECT_ORG|PA_PROJECT_ORG|A||HRC_SQLLOADER|PJF_FEB_23_CLASS_PTOO_"+i;
			
			//System.out.println(str2);
			
			String str3 = "MERGE|OrgInformation|Project Type Class Information|Y|Y|Y|2019/01/01|4712/12/31|PA_PROJECT_ORG|Project Task Owning Organization|Project Type Class Information|PJF_DEMO_DEP_"+i+"|PA_PROJECT_ORG|1|HRC_SQLLOADER|PJF_DEMO_INFO_PTOO_"+i+"|PJF_FEB_23_SYSID_"+i;
			
			System.out.println(str3);
		}
	}
}
