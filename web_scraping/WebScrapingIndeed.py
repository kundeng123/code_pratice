import requests
import smtplib
import sqlite3

from bs4 import BeautifulSoup


def extract_job_title_from_result(soupContent, queryResult):
    jobs = []
    links = []
    job_id = []
    for div in soupContent.find_all(name="div", attrs={"class":"row"}):
        if div['id'] not in queryResult:
            job_id.append(div['id'])
    #print(job_id)
            #print(div[div['id']])
    for newJobId in job_id:
        for div in soupContent.find_all(name="div", attrs={"id":newJobId}):
            for a in div.find_all("div", {"class": "title"}):
                jobs.append(a.find("a")['title'])
                #for b in a.find_all(name="a", href=True, attrs={"target": "_blank"}):
                links.append(a.find("a")['href'])

    return jobs, job_id, links

def extract_company_from_result(soupContent, job_id):
    companies = []
    for newJobId in job_id:
        for div in soup.find_all(name="div",  attrs={"id":newJobId}):
            company = div.find_all(name="span", attrs={"class": "company"})
            if len(company) > 0:
                for item in company:
                    companies.append(item.text.strip())

    return companies

def extract_summary_from_result(soupContent, job_id):
    summaries = []
    for newJobId in job_id:
        for div in soup.find_all(name="div", attrs={"id": newJobId}):
            for div in soupContent.find_all(name="div", attrs={"class": "summary"}):
                summaries.append(div.text.strip())


    return summaries

def extract_location_from_result(soupContent, job_id):
    locations = []
    for newJobId in job_id:
        for div in soupContent.find_all(name="div", attrs={"id": newJobId}):
            for span in div.find_all(name="span", attrs={"class": "location"}):
                locations.append(span.text.strip())

    return locations


conn = sqlite3.connect('Job.db')
conn.execute('''create table if not exists job_lkup  (job_id varchar(50) primary key not null, job_title varchar(50),
                company varchar(50), summary varchar(225), location varchar(50), job_link varchar(50), update_time varchar(50));''')

result = []
cursor = conn.execute("SELECT job_id from job_lkup")
for row in cursor:
    result.append(row[0])
#print(result)

URL = "https://www.indeed.hk/jobs?q=developer&l=hong+kong&start=10"
#conducting a request of the stated URL above:
page = requests.get(URL)
#specifying a desired format of “page” using the html parser - this allows python to read the various components of the page, rather than treating it as one long string.
soup = BeautifulSoup(page.text, "html.parser")


jobs, jobId, links = extract_job_title_from_result(soup, result)
companyName = extract_company_from_result(soup, jobId)
summary = extract_summary_from_result(soup,jobId)
location = extract_location_from_result(soup,jobId)
#print(summary)

for i in range(len(jobId)):
    try:
        conn.execute("INSERT INTO job_lkup (job_id,job_title,company,summary, location, job_link, update_time) \
          VALUES ("+"'"+jobId[i]+"','"+jobs[i] +"','"+companyName[i]+"','"+summary[i]+"','"+location[i]+"','"+links[i]+"',  DateTime('now') )");
    except sqlite3.Error as e:
        print("Database error: %s" % e)
    except Exception as e:
        print("Exception in _query: %s" % e)

'''negative testing'''
try:
    conn.execute("INSERT INTO job_lkup (job_id,job_title,company,summary, location, job_link, update_time) \
             values('p_b61a99701baf4489', 'COO – Technology Service Analyst - Associate', 'Deutsche Bank', \
             'Oracle query creation, execution, and efficient usage of SQL Developer or similar \
             (i.e. Regular/Temporary:....', 'Hong Kong', '/rc/clk?jk=b61a99701baf4489&fccid=f1d8e147024abb3f&vjs=3', '2019-06-15 04:21:57');")
except sqlite3.Error as e:
    print("Database error: %s" % e)

conn.commit()
#cursor = conn.execute("SELECT * from job_lkup")


#print(jobTitleList)
#test = extract_location_from_result(soup)
#print(jobId)

sender_email = "my@gmail.com"  # Enter your address
receiver_email = "your@gmail.com"  # Enter receiver address
server = smtplib.SMTP("localhost",1025)
server.sendmail(sender_email,receiver_email,"testing")

conn.close()

'''
('p_95cf0269213feec7', 'Algorithmic Developer', 'Haitong', 'Division / Department: Institutional Equities Department Job Description: Ongoing development and customization of a wide range of execution strategies,...', 'Hong Kong', '/rc/clk?jk=95cf0269213feec7&fccid=36397b2181f4c232&vjs=3', '2019-06-15 04:16:18')
('p_ad63374a60b18d9b', 'Graduate C++ Software Developer | 2019 Intake', 'Eclipse Trading', 'Graduate C++ Software Developer | 2019 Intake. As a Graduate Developer, you will receive comprehensive 8-week training in our Hong Kong headquarters,where you...', 'Hong Kong', '/rc/clk?jk=ad63374a60b18d9b&fccid=463d1294d7a31741&vjs=3', '2019-06-15 04:16:18')
('p_6b39f6770ad509f4', 'Web Developer', 'MatchTalent Limited', 'Our client provides digital marketing solutions with state-of-the-art AI technology. They are seeking out web developers to cope with their rapid growth and...', 'Hong Kong', '/rc/clk?jk=6b39f6770ad509f4&fccid=3c1ba8cd1106b128&vjs=3', '2019-06-15 04:16:18')

'''