import requests
import bs4
from bs4 import BeautifulSoup


URL = "https://www.indeed.hk/jobs?q=developer&l=hong+kong"
#conducting a request of the stated URL above:
page = requests.get(URL)
#specifying a desired format of “page” using the html parser - this allows python to read the various components of the page, rather than treating it as one long string.
soup = BeautifulSoup(page.text, "html.parser")
#printing soup in a more structured tree format that makes for easier reading
#print(soup.prettify())


def extract_job_title_from_result(soupContent):
    jobs = []
    for div in soupContent.find_all(name="div", attrs={"class":"row"}):
      for a in div.find_all(name="a", attrs={"data-tn-element":"jobTitle"}):
        jobs.append(a["title"])
    return jobs

def extract_company_from_result(soupContent):
    companies = []

    for div in soup.find_all(name = "div", attrs = {"class":"row"}):
        company = div.find_all(name = "span", attrs = {"class":"company"})
        if len(company) > 0:
            for item in company:
                companies.append(item.text.strip())

    return companies

def extract_summary_from_result(soupContent):
    summaries = []
    for div in soupContent.find_all(name = "div", attrs = {"class":"summary"}):
        summaries.append(div.text.strip())

    return summaries

def extract_location_from_result(soupContent):
    locations = []
    for div in soupContent.find_all(name = "div", attrs = {"class": "sjcl"}):
        for span in div.find_all(name = "span", attrs = {"class":"location"}):
            locations.append(span.text.strip())
    return locations

#jobTitleList = extract_job_title_from_result(soup)
#print(jobTitleList)
test = extract_location_from_result(soup)
print(test)

