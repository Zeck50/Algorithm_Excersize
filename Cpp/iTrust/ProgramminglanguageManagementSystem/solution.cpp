#include<vector>
#include<utility>
#include<iostream>

using namespace std;

enum LanguageEnum{
    C,
    CPP,
    GO,
    JAVA,
    JAVASCRIPT,
    PYTHON,
    RUST,
    MAXLANGUAGE
};

struct CodeRepo
{
    int repoId;
    int languageId;
    int codeline;
};

struct Product
{
    int productId;
    vector<CodeRepo> codeRepoVec;
};

class CodeStatsSystem{
    vector<Product> productVec;
    public:
    CodeStatsSystem(const vector<pair<int,vector<int>>>& products)
    {
        for(int i = 0; i < products.size(); i++)
        {
            int tempProductId = products[i].first;
            vector<CodeRepo> tempcodeRepoVec;
            for(int j=0; j < products[i].second.size(); j++)
            {
                for(int k = C; k < MAXLANGUAGE; k++)
                {
                    CodeRepo tempCodeRepo;
                    tempCodeRepo.repoId = products[i].second[j];
                    tempCodeRepo.languageId = k;
                    tempCodeRepo.codeline = 0;
                    tempcodeRepoVec.push_back(tempCodeRepo);
                }
            }
            Product tempProduct = {tempProductId,tempcodeRepoVec};
            productVec.push_back(tempProduct);
        }
    }

    int ChangeCodelines(int repoId, int languageId, int codeline)
    {
        int productIndex;
        int codeRepoIndex;
        for(int i = 0; i < productVec.size(); i++)
        {
            for(int j = 0; j < productVec[i].codeRepoVec.size(); j++)
            {
                if(productVec[i].codeRepoVec[j].repoId == repoId && productVec[i].codeRepoVec[j].languageId == languageId)
                {
                    productIndex=i;
                    codeRepoIndex=j;
                    productVec[i].codeRepoVec[j].codeline += codeline;
                }
            }
        }

        int result=productVec[productIndex].codeRepoVec[codeRepoIndex].codeline;
        return result;
    }

    vector<int> StatLanguage(int productId)
    {
        vector<pair<int,int>> statisticsInfo={
            {C,          0},
            {CPP,        0},
            {GO,         0},
            {JAVA,       0},
            {JAVASCRIPT, 0},
            {PYTHON,     0},
            {RUST,       0}
        };
        if(productId==0)
        {
            for(int i=0;i<productVec.size();i++)
            {
                for(int j=0;j<productVec[i].codeRepoVec.size();j++)
                {
                    for(int k=0;k<statisticsInfo.size();k++)
                    {
                        if(productVec[i].codeRepoVec[j].languageId==k)
                        {
                            statisticsInfo[k].second+=productVec[i].codeRepoVec[j].codeline;
                        }
                    }
                }
            }
        }
        else{
            for(int i=0;i<productVec.size();i++)
            {
                if(productVec[i].productId==productId)
                {
                    for(int j=0;j<productVec[i].codeRepoVec.size();j++)
                    {
                        for(int k=0;k<statisticsInfo.size();k++)
                        {
                            if(productVec[i].codeRepoVec[j].languageId==k)
                            {
                                statisticsInfo[k].second+=productVec[i].codeRepoVec[j].codeline;
                            }
                        }
                    }
                }
            }
        }
        
        for(int i=0; i < statisticsInfo.size(); i++)
        {
            for(int j=i+1;j<statisticsInfo.size();j++)
            {
                if(statisticsInfo[i].second < statisticsInfo[j].second)
                {
                    swap(statisticsInfo[i],statisticsInfo[j]);
                }
                if(statisticsInfo[i].second == statisticsInfo[j].second)
                {
                    if(statisticsInfo[i].first > statisticsInfo[j].first)
                    {
                        swap(statisticsInfo[i],statisticsInfo[j]);
                    }
                }
            }
        }

        vector<int> result;
        for(int i=0;i<statisticsInfo.size();i++)
        {
            if(statisticsInfo[i].second>0)
            {
                result.push_back(statisticsInfo[i].first);
            } 
        }
        return result;
    }
};

void print(vector<int> input)
{
    if(input.empty())
    {
        cout<<"[]"<<endl;
        return;
    }
    for(int i=0;i<input.size();i++)
    {
        cout<<input[i]<<" ";
    }
    cout<<endl;
}

int main()
{
    do
    {
        cout<<"============TestCase 1============"<<endl;
        CodeStatsSystem codeStatsSys(std::vector<std::pair<int, std::vector<int>>>{{10,{102,101}}, {12,{122}}, {22,{221}}});
        cout<<codeStatsSys.ChangeCodelines(221,3,500)<<endl;
        cout<<codeStatsSys.ChangeCodelines(102,2,1900)<<endl;
        cout<<codeStatsSys.ChangeCodelines(101,1,2000)<<endl;
        cout<<codeStatsSys.ChangeCodelines(101,2,200)<<endl;
        vector<int> codeStats1=codeStatsSys.StatLanguage(10);
        print(codeStats1);
        vector<int> codeStats2=codeStatsSys.StatLanguage(22);
        print(codeStats2);
        cout<<codeStatsSys.ChangeCodelines(102,3,2000)<<endl;
        cout<<codeStatsSys.ChangeCodelines(102,2,-100)<<endl;
        vector<int> codeStats3=codeStatsSys.StatLanguage(0);
        print(codeStats3);
        cout<<endl;
    } while (0);
     

    do
    {
        cout<<"============TestCase 2============"<<endl;
        CodeStatsSystem codeStatsSys(std::vector<std::pair<int, std::vector<int>>>{{10, {102, 101}}});
        vector<int> codeStats1=codeStatsSys.StatLanguage(0);
        print(codeStats1);
        cout<<codeStatsSys.ChangeCodelines(102,2,100)<<endl;
        vector<int> codeStats2=codeStatsSys.StatLanguage(0);
        print(codeStats2);
        cout<<codeStatsSys.ChangeCodelines(102,2,-100)<<endl;
        vector<int> codeStats3=codeStatsSys.StatLanguage(0);
        print(codeStats3);
    } while (0);
    return 0;
}